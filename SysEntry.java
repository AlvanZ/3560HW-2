public abstract class SysEntry {
        public boolean addSysEntry(SysEntry newEntry){
            throw new SecurityException ("Cannot do this");
        }
        public String getDisplayName(){
            return "";
        }
        public boolean isGroup(){
            return false;
        }  
        public boolean isUser(){
            return false;
        }  
        public long getTime(){
            return 0;
        }

    }

