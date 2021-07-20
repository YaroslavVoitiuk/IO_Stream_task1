import java.io.*;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        StringBuilder sb = new StringBuilder();

        File dir1 = new File("/Users/yaroslavvoitiuk/Games");

        if (dir1.mkdir()) {
            sb.append("* Папка " + dir1.getName()+ " успешно создана\n");
        }

        File src = new File(dir1, "src");
        File res = new File(dir1, "res");
        File savegames = new File(dir1, "savegames");
        File temp = new File(dir1, "temp");
        File main = new File(src, "main");
        File test = new File(src, "test");
        File drawables = new File(res, "drawables");
        File vectors = new File(res, "vectors");
        File icons = new File(res, "icons");
        File mainJava = new File(main, "Main.java");
        File utilsJava = new File(main, "Utils.java");
        File tempFile = new File(temp,"temp.txt");

        if(src.mkdir() && res.mkdir() && savegames.mkdir() && temp.mkdir() && main.mkdir() && test.mkdir() &&
        drawables.mkdir() && vectors.mkdir() && icons.mkdir()){
            sb.append("* Директории были успешно созданы\n");
        }

        try {
            if (mainJava.createNewFile() && utilsJava.createNewFile() && tempFile.createNewFile()) {
                sb.append("* Файлы были успешно созданы\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            FileWriter fw = new FileWriter(tempFile,false);
            fw.write(sb.toString());
            fw.close();
        } catch (IOException e) {
            e.getMessage();
        }

        try {
            FileReader fr = new FileReader(tempFile);
                int c;
                while((c = fr.read()) != -1 ){
                    System.out.print((char) c);
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
