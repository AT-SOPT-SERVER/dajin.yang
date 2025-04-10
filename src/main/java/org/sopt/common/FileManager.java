package org.sopt.common;

import org.sopt.damain.core.Post;
import org.sopt.exception.BusinessException;
import org.sopt.exception.ErrorCode;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private static final String FILE_PATH = "src/main/java/org/sopt/assets/Post.txt";

    public static void saveFile(List<Post> postList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Post post : postList) {
                writer.write(post.getId() + "," + post.getTitle());
                writer.newLine();
            }
        } catch (IOException ex) {
            throw new BusinessException(ErrorCode.FILE_SAVE_ERROR);
        }
    }

    public static List<Post> loadFile() {
        List<Post> posts = new ArrayList<>();
        java.io.File file = new java.io.File(FILE_PATH);
        if (!file.exists()) return posts;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] split = line.split(",", 2);
                int id = Integer.parseInt(split[0]);
                String title = split[1];
                posts.add(new Post(id, title));
            }
        } catch (IOException ex) {
            throw new BusinessException(ErrorCode.FILE_LOAD_ERROR);
        }

        return posts;
    }

}

