package com.example.medaijam;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import static com.example.medaijam.EnterFragment.h;

public class HRFragment extends Fragment{

    View view;
    LineGraphSeries<DataPoint> series;
    Dataset.getHR h = EnterFragment.h;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_hr, null);

        double y,x;

        GraphView graph = (GraphView) view.findViewById(R.id.chart1);

        series = new LineGraphSeries<DataPoint>();

        graph.getViewport().setMinX(0.0);
        graph.getViewport().setMaxX(13.0);
        graph.getViewport().setMinY(60.0);
        graph.getViewport().setMaxY(80.0);

        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setXAxisBoundsManual(true);

        for (int i = 0; i < h.wantHR().size(); i++) {
            x = i * 2;
            y = h.wantHR().get(i);
            series.appendData(new DataPoint(x,y), true, 100);
        }
        graph.addSeries(series);

        return view;
    }
}