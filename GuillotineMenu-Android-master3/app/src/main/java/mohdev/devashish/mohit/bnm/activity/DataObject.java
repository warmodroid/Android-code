package mohdev.devashish.mohit.bnm.activity;

/**
 * Created by Devashish on 16-02-2016.
 */
public class DataObject {

        public DataObject(String id,String usn,String name,String subject,String branch,String sem,String file_add,String label)
        {
            this.id = id;
            this.file_add = file_add;
            this.branch = branch;
            this.sem = sem;
            this.label = label;
            this.usn = usn;
            this.name = name;
            this.subject = subject;
        }
        public String id;
        public  String usn;
        public String name;
        public String subject;
        public String branch;
        public  String sem;
        public String file_add;
        public  String label;



}
