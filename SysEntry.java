public abstract class  SysEntry {
        public boolean addSysEntry(SysEntry newEntry){
            throw new SecurityException ("Cannot do this");
        }
        public String getDisplayName(){
            return "";
        }

    }

