package info.androidhive.slidingmenu.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import info.androidhive.slidingmenu.R;
import info.androidhive.slidingmenu.model.Contributor;

/**
 * Created by i on 20.12.14.
 */
public class ContributorListAdapter extends ArrayAdapter<Contributor> {
    private final Context context;
    private final List<Contributor> contributors;

    public ContributorListAdapter(Context context, List<Contributor> contributors){
        super(context, R.layout.contributor_list_item, contributors);
        this.context = context;
        this.contributors = contributors;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.contributor_list_item, parent, false);

        Contributor c = contributors.get(position);
        TextView cName = (TextView) rowView.findViewById(R.id.contr_name);
        ImageView cIcon = (ImageView) rowView.findViewById(R.id.contr_icon);
        TextView cContr = (TextView) rowView.findViewById(R.id.contr_count);

        cName.setText(c.getLogin());
        cContr.setText(c.getContributions());

        // TODO Laden der Icons aus dem Intenet
        cIcon.setImageURI(Uri.parse(c.getAvatarUrl()));


        return rowView;
    }
}
