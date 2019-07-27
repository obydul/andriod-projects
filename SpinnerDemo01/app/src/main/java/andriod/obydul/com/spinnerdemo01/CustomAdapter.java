package andriod.obydul.com.spinnerdemo01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    private String[] countryNames;
    private int[] flags;
    private String[] population;
    Context context;
    private LayoutInflater inflater;

    public CustomAdapter(Context context, int[] flags, String[] countryNames, String[] population) {
        this.countryNames = countryNames;
        this.flags = flags;
        this.population = population;
        this.context = context;
    }

    @Override
    public int getCount() {
        return countryNames.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view==null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.sample_view,null,false);
        }
        ImageView imageView = view.findViewById(R.id.imageViewId);
        imageView.setImageResource(flags [position]);

        TextView textView = view.findViewById(R.id.countryNameTextViewId);
        textView.setText(countryNames[position]);

        TextView textView1 = view.findViewById(R.id.populationTextViewId);
        textView1.setText(population[position]);


        return view;
    }
}
