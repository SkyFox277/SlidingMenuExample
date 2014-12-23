package info.androidhive.slidingmenu.interfaces;

import java.util.List;


import info.androidhive.slidingmenu.model.Contributor;
import info.androidhive.slidingmenu.model.Group;
import retrofit.client.Header;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Path;

public interface BMAPIService {

    @Headers({"Accept: application/json"
    })
    @GET("/group/{group}")
    Group group(
            @Path("group") String group

    );

    @Headers({"Accept: application/json"
    })
    @GET("/group")
    List<Group> groups(
    );

//    @GET("/users/{user}/repos")
//    List<Repo> listRepos(
//            @Path("repo") String repo
//    );
}
