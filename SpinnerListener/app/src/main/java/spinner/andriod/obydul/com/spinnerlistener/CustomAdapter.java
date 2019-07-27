package spinner.andriod.obydul.com.spinnerlistener;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

class CustomAdapter extends BaseAdapter {
    private Context context;
    private String[] countryNames;
    private String[] population;
    private int[] flags;

    public CustomAdapter(Context context, int[] flags, String[] countryNames, String[] population){
        this.context = context;
        this.countryNames = countryNames;
        this.population = population;
        this.flags = flags;
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
        if (view == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.sample_view,null, false);
        }
        ImageView imageView = view.findViewById(R.id.imageViewId);
        imageView.setImageResource(flags[position]);

        TextView txtCountry=view.findViewById(R.id.txtCountryName);
        txtCountry.setText(countryNames[position]);

        TextView txtPopulation = view.findViewById(R.id.txtCountryPopulation);
        txtPopulation.setText(population[position]);


        return view;
    }
}
