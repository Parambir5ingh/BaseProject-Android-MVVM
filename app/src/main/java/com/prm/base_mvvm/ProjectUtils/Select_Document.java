package com.prm.base_mvvm.ProjectUtils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.prm.base_mvvm.R;
import com.prm.base_mvvm.WebServices.Web;

import java.io.File;
import java.util.ArrayList;

public class Select_Document extends AppCompatActivity {



    RecyclerView recycle_list_view;
    Activity con;
    ArrayList<String> map_values = new ArrayList<String>();
    String Document_type = "";
    ArrayList<File> fileList = new ArrayList<>();



    public static void startActivity(Fragment mActivity, String document_type)
    {
        Intent in=new Intent(mActivity.getActivity(),Select_Document.class);
        in.putExtra("document_type",document_type);
        mActivity.startActivityForResult(in,1011);
    }


    public static void startActivity(Activity mActivity, String document_type)
    {
        Intent in=new Intent(mActivity,Select_Document.class);
        in.putExtra("document_type",document_type);
        mActivity.startActivityForResult(in,1011);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_document);
        con = this;
        Document_type = getIntent().getStringExtra("document_type");
        initailise();
        Load_Document load=  new Load_Document(con,true);
        load.execute();
    }

    public void initailise() {


        setupToolbar("Select File");
        recycle_list_view=(RecyclerView)findViewById(R.id.recycle_list_view);

    }

    public void setupToolbar(String title)
    {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private ArrayList<File> GET_LIST(File parentDir) {

       File[] fileNames = parentDir.listFiles();

        try {
            for (File fileName : fileNames) {

                if (fileNames != null) {

                    if (fileName.isDirectory()) {
                        File[] fileNames_inter = fileName.listFiles();

                        for (File fileNames_inter1 : fileNames_inter) {
                            selectFile(fileNames_inter1);
                        }

                    } else {
                        selectFile(fileName);
                    }
                }
            }
        }
        catch(Exception ex){
            Log.e("Exception is",ex.toString());
        }



        return fileList;
    }


    public void selectFile(File fileSelected){
        if (Document_type.equals(Web.File_Options.PDF)) {

            if (fileSelected.getPath().endsWith(".pdf")) {
                fileList.add(fileSelected);
            }
        } else if (Document_type.equals(Web.File_Options.DOC)) {
            if (fileSelected.getPath().endsWith(".docx")
                    || fileSelected.getPath().endsWith(".doc")) {
                fileList.add(fileSelected);
            }
        }
        else if (Document_type.equals(Web.File_Options.VIDEO)) {
            if (fileSelected.getPath().endsWith(".avi")
                    || fileSelected.getPath().endsWith(".flv")
                    || fileSelected.getPath().endsWith(".wmv")
                    || fileSelected.getPath().endsWith(".mov")
                    || fileSelected.getPath().endsWith(".mp4")) {
                fileList.add(fileSelected);
            }
        }
        else if (Document_type.equals(Web.File_Options.AUDIO)) {
            if (fileSelected.getPath().endsWith(".wav")
                    || fileSelected.getPath().endsWith(".mp3")
                    || fileSelected.getPath().endsWith(".wma")
                    || fileSelected.getPath().endsWith(".ogg")) {
                fileList.add(fileSelected);
            }
        }
        else if (Document_type.equals(Web.File_Options.TEXT)) {
            if (fileSelected.getPath().endsWith(".txt")) {
                fileList.add(fileSelected);
            }
        }
    }


    class Load_Document extends AsyncTask<Void, Void, String>
    {

       Boolean internal;
        Context con;


        public Load_Document(Context con, Boolean internal)
        {
            this.internal=internal;
            this.con=con;
        }

        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();

              BaseUtils.showLoading("Fetching data",Select_Document.this);


        }

        @Override
        protected String doInBackground(Void... params)
        {
          if(internal){
              GET_LIST(getFilesDir());
          }
            else{
              GET_LIST(Environment.getExternalStorageDirectory());
          }

            return "";
        }

        @Override
        protected void onPostExecute(String ResponseString)
        {
            super.onPostExecute(ResponseString);
            BaseUtils.hideLoading();
           if(internal){
               Load_Document load=  new Load_Document(con,false);
               load.execute();
           }
            else{

               LinearLayoutManager manager = new LinearLayoutManager(con);
               manager.setOrientation(LinearLayoutManager.VERTICAL);
               recycle_list_view.setLayoutManager(manager);
               recycle_list_view.setHasFixedSize(true);
               Documents_Adapter adapter = new Documents_Adapter(Select_Document.this, fileList);
               recycle_list_view.setAdapter(adapter);
           }

        }
    }




    public ArrayList<File> GET_FILE() {

        File dir = new File(Environment.getExternalStorageDirectory().getAbsolutePath());
        ArrayList<File> fileList = new ArrayList<>();
        File listFile[] = dir.listFiles();
        if (listFile != null && listFile.length > 0) {
            for (int i = 0; i < listFile.length; i++) {
                if (Document_type.equals("PDF")) {
                    if (listFile[i].getPath().endsWith(".pdf")) {
                        fileList.add(listFile[i]);
                    }
                } else if (Document_type.equals("DOC")) {
                    if (listFile[i].getPath().endsWith(".docx")
                            || listFile[i].getPath().endsWith(".doc")) {
                        fileList.add(listFile[i]);
                    }
                }
            }
            LinearLayoutManager manager = new LinearLayoutManager(con);
            manager.setOrientation(LinearLayoutManager.VERTICAL);
            recycle_list_view.setLayoutManager(manager);
            recycle_list_view.setHasFixedSize(true);
            Documents_Adapter adapter = new Documents_Adapter(Select_Document.this, fileList);
            recycle_list_view.setAdapter(adapter);

        }
        return fileList;
    }

    public class Documents_Adapter extends RecyclerView.Adapter<Documents_Adapter.CustomViewHolder> {

        Context con;
        ArrayList<File> documents = null;

        public Documents_Adapter(Context con, ArrayList<File> documents) {
            this.con = con;
            this.documents = documents;

        }

        @Override
        public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.inflater_item_select_document, parent, false);
            final CustomViewHolder viewholder = new CustomViewHolder(v);
            return viewholder;
        }

        @Override
        public void onBindViewHolder(final CustomViewHolder holder, final int position) {


            holder.document_name.setText(documents.get(position).getName());

            holder.document_name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in = new Intent();
                    in.putExtra("file_name", documents.get(position).getName());
                    in.putExtra("file_path", documents.get(position).getAbsolutePath());
                    in.putExtra("Document_type",Document_type);
                    setResult(Activity.RESULT_OK, in);
                    finish();
                }
            });

        }

        @Override
        public int getItemCount() {
            return documents.size();
        }

        public class CustomViewHolder extends RecyclerView.ViewHolder {

            TextView document_name;

            public CustomViewHolder(View view) {
                super(view);
                document_name=(TextView)view.findViewById(R.id.document_name);

            }
        }


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        BaseUtils.hideLoading();
    }
}
