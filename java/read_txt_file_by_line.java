import java.io.*

public static void readFile(String path) {
        long start = System.currentTimeMillis();//开始时间
        File file = new File(path); 
        if (file.isFile()) { 
            /*使用Reader家族，表示我要读字符数据了，
             *使用该家族中的BufferedReader，表示我要建立缓冲区读字符数据了。
             * */
            BufferedReader bufferedReader = null; 
            FileReader fileReader = null; 
            try { 
                fileReader = new FileReader(file);
                //嵌套使用，装饰者模式，老生常谈。装饰者模式的使用，可以读前面小砖写的《从熏肉大饼到装饰者模式》
                bufferedReader = new BufferedReader(fileReader); 
                String line = bufferedReader.readLine(); 
                //一行一行读
                while (line != null) { //按行读数据
                    System.out.println(line); 
                    line = bufferedReader.readLine(); 
                } 
            } catch (FileNotFoundException e) { 
                e.printStackTrace(); 
            } catch (IOException e) { 
                e.printStackTrace(); 
            } finally { 
                //最后一定要关闭
                try { 
                    fileReader.close(); 
                    bufferedReader.close(); 
                } catch (IOException e) { 
                    e.printStackTrace(); 
                } 
                long end = System.currentTimeMillis();//结束时间
                System.out.println("传统IO读取数据，不指定缓冲区大小，总共耗时："+(end - start)+"ms");
            } 
   
        } 
    }
