package info.androidhive.slidingmenu.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;
import java.util.List;

import info.androidhive.slidingmenu.R;
import info.androidhive.slidingmenu.interfaces.BMAPIService;
import info.androidhive.slidingmenu.model.Contributor;
import info.androidhive.slidingmenu.interfaces.GithubApiService;
import info.androidhive.slidingmenu.model.Group;
import retrofit.RestAdapter;
import retrofit.client.Client;
import retrofit.client.Request;
import retrofit.client.Response;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class WhatsHotFragment extends Fragment implements View.OnClickListener {
	
	public WhatsHotFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_whats_hot, container, false);

        Button buttonGitHub = (Button) rootView.findViewById(R.id.buttonGitHub);
        buttonGitHub.setOnClickListener(this);

        return rootView;


    }

    public void getGitHubInfos (){
        new GetUserInfo().execute();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonGitHub:
                getGitHubInfos();
                break;

        }
    }

    private class GetUserInfo extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... params) {
            // TODO Auto-generated method stub
            try{

                EditText owner = (EditText) getActivity().findViewById(R.id.github_owner);
                EditText repo = (EditText) getActivity().findViewById(R.id.github_repo);

                String ownerStr = owner.getText().toString().trim();
                String repoStr = repo.getText().toString().trim();

                if (ownerStr.length()>0 && repoStr.length()>0) {
                    RestAdapter restAdapter = new RestAdapter.Builder()
                            .setEndpoint("http://172.16.5.1")
                                    //"https://api.github.com")
                            .build();

                    restAdapter.setLogLevel(RestAdapter.LogLevel.FULL);

//                    GithubApiService githubApiService = restAdapter.create(GithubApiService.class);
//                    List<Contributor> contributors = githubApiService.contributors(ownerStr, repoStr);
//
//
//
//                    String tmpGitHubText = "";
//
//                    for (Contributor contributor : contributors) {
//                        Log.d("", contributor.getLogin() + contributor.getContributions());
//                        tmpGitHubText+= contributor.getLogin() + " - " + contributor.getContributions() + "\n";
//                    }
//
//                    updateText(getActivity(), R.id.textGitHub, tmpGitHubText);

                    BMAPIService ApiService = restAdapter.create(BMAPIService.class);
                    Group group1 = ApiService.group("1");
                    List<Group> groups = ApiService.groups();



                    String tmpText = "";
                    tmpText+= group1.getName() + "; " + group1.getDescription() + "; " + group1.getOwner() + "\n";
                    tmpText+=  "-------------------------------\n";

                    for (Group group : groups) {
                        Log.d("", group.getName() + "; " + group.getDescription() + "; " + group.getOwner());
                        tmpText+= group.getName() + "; " + group.getDescription() + "; " + group.getOwner() + "\n";
                    }

                    updateText(getActivity(), R.id.textGitHub, tmpText);

                }else{
                    showToast("Die Felder Besitzr und Repository dürfen nicht leer sein.");

                }
            }catch(Exception e){
                e.printStackTrace();

                if (e.getMessage() == "404 Not Found") {
                    showToast("Besitzer - Repository Kombination existiert nicht.");
                }
                return "failure";

            }
            return "success";
        }
    }

    public static void updateText(Activity act, int textId, final String value)
    {
        final TextView loadingText;
        loadingText = (TextView) act.findViewById(textId);
        act.runOnUiThread(new Runnable()
        {
            public void run()
            {
                loadingText.setText(value);

            }
        });
    }

    public void showToast(final String value)
    {
        final Activity act = getActivity();

        act.runOnUiThread(new Runnable()
        {
            public void run()
            {
                Toast.makeText(act.getApplicationContext(), value, Toast.LENGTH_LONG).show();
            }
        });
    }
}
