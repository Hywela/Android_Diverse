//Eksemple på nedlasting av et rtf dokument     String str = DownloadText("http://www.ettellerannet");

   private String DownloadText(String strURL)
   {
   	int BUFFER_SIZE = 2000;
       InputStream in = null;
       OpenHttpConnection obj = new OpenHttpConnection(strURL);
       in = obj.sendWith();
       InputStreamReader isr = new InputStreamReader(in);
       int charRead;
       in = obj.sendWith();
       
       String returnString = "";
       char[] inputBuffer = new char[BUFFER_SIZE];          
       try {
           while ((charRead = isr.read(inputBuffer))>0)
           {                    
               //---convert the chars to a String---
               String readString = 
                   String.copyValueOf(inputBuffer, 0, charRead);                    
               returnString += readString;
               inputBuffer = new char[BUFFER_SIZE];
           }
           in.close();
          obj.close(); obj = null;
       } catch (IOException e) {
           e.printStackTrace();
           return "";
       }    
       return returnString;
   }
