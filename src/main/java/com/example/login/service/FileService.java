package com.example.login.service;

import com.example.login.exception.BadRequestException;
import com.example.login.model.respo.FileRes;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service // khi đanhs dấu anotion này thì lúc chạy bean sẽ tự tiêm vào và khởi tạo lun trong ctrstor
public class FileService {
    private final Path rootPath= Paths.get("uploads"); // taọ 1 trường có class Path (class này dùng để tạo ra và thao tác với các thư mục)
      // Paths.get : tạo thư mục trong đường dẫn có file
    public FileService(){
        createFolder(rootPath.toString()
        );
    }
    private void createFolder(String path){
        File file = new File(path); // tạo file trong dẫn dường Path
        if(!file.exists()){ // nếu file đã tồn tại thì thôi , còn chưa thì tạo
            file.mkdir(); // method tạo file
        }
    }


    public FileRes uploadFile(MultipartFile file) {
      validateFile(file); // đưa file vào check Excetion
      String fileID = UUID.randomUUID().toString(); // chuyển chuổi Random thành dạng String
      Path filePath = rootPath.resolve(fileID); // tạo ra đối tượng mới từ chuỗi gốc
      File fileUpload = filePath.toFile(); // chuyển đổi Path thành File để dễ thao tác
    try(OutputStream outputStream = new FileOutputStream(fileUpload)){
        outputStream.write(file.getBytes());
        return new FileRes("/api/v1/files/"+fileID); // dẫn dễn file chứa nội dụng các byte tạo nên hình ảnh
    }catch (IOException e){
        System.out.println(e.getMessage());
        throw new RuntimeException("Lỗi trong quá trình upload File");
    }
    }

    public byte[] readFile(String id){
        Path filePath = rootPath.resolve(id);
        File file = new File(filePath.toString());
        if(!file.exists()){
            throw new BadRequestException("Không tìm thấy File");
        }
        try{
            return Files.readAllBytes(filePath);
        }catch (IOException e){
            throw new BadRequestException("Lỗi trong quá trình đọc file");
        }
    }
    public void validateFile(MultipartFile file){
//        String fileName = file.getOriginalFilename();
//        if(fileName == null || fileName.isEmpty()){
//            throw new BadRequestException("Tên file ko hợp lệ ");
//        }
//        if(!checkFileExtension(getFileExxtension(fileName))){
//            throw new BadRequestException("Duoi file ko hop le");
//        }
//
//        // check dung luong
//        double fileSize = (double) (file.getSize()/ 1048576);
//        if (fileSize > 2) {
//            throw new BadRequestException("Size file khong dc vuot qua 2MB");
//        }
//
        String fileName = file.getOriginalFilename(); // lấy ra tên file gốc
        if(fileName == null || fileName.isEmpty()){            // bắt lỗi file k trống
            throw new BadRequestException("Tên file không được để trống");
        }
        if(!checkFileExtension(getFileExxtension(fileName))) // xét đuôi file là gì
        {
            throw new BadRequestException("Định dạng file không hợp lệ ");
        }
        double fileSize = (double) (file.getSize() / 1048576 );
        if(fileSize > 2  ){
            throw  new BadRequestException("Dung Lượng File vượt quá 2MB , vui lòng upload ảnh nhẹ hơn ");
        }
    }

    public String getFileExxtension(String fileName){
        int lastIndex = fileName.lastIndexOf(".");
        if(lastIndex == -1){
            throw new BadRequestException("File ko xác định ");
        }
        return fileName.substring(lastIndex+1);
    }

    public boolean checkFileExtension(String fileName){
        List<String> fileExxtensions = List.of("png","jpg","jpeg");
        return fileExxtensions.contains(fileName);
    }

}
