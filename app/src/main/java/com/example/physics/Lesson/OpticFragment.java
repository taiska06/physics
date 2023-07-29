package com.example.physics.Lesson;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.physics.Adapter.MyAdapterOptic;
import com.example.physics.R;

import java.util.ArrayList;


public class OpticFragment extends Fragment  {

    private final String image_names[] = {
            "Clouds",
            "Sun",
            "Partial clouds",
            "Snow",
            "Sleet",
            "Mist",
            "Clear",
            "Rain",
            "Rain thunder",
            "Fog",
            "Clouds",
            "Sun",
            "Partial clouds",
            "Snow",
            "Sleet",
            "Mist",
            "Clear",
            "Rain",
            "Rain thunder",
            "Fog"
    };

    private final String[] image_urls = {
            "https://yandex.ru/an/count/WXiejI_zOoVX2LdO0MqG09DTSYOQbKgbKga4mGHzFfSxUxRVkVDTNpjVl-FrXZjSPLCv-046UNLAVo55KasGEmmwZdxA5o1GMJpqjcnrjluC-AGgxalP2n5d-Qm0hRDSLe3MMIOhGEiiP2f0woJiKe3MIMWkGElCUN9RYZlp1V8eZ_t4SsTEGm2RRPND-PgG0WDa2tS33ZbTeHrIMwGX71cnc37ZUeCdnOiNCpXO6r5qMkosNL95RhmKU3mPSerDKf5oi_UKCEJafi3vVCFKGL4FqSQxBDi9hFBYaYW4wr2hOMyAmJhKQjXgfQnvlQ7j_T5mcoH9J6iw51avosK1R3605H6I1Me9XgpFKZNvkbBo9Qf8JvOUCsIoooqPNMQ74guOSZCFv647AN4X1KmtEm064wPsANgQUXIMx7rn04ssVZX5NVQ3AIn9yhyKbYJvNWfBadnkXKBmtn6G8lYr0-YT_Im2KWIPPfWkPfbertLTnzBc2KQkkh9qeuQhhJTwjmaJTAItE9trTOHS4hrvYUNB7joqQ3tPlpdvwl9ZseCDu27unVLV8YLuInxzbjPr_OeIl2MFNklD9lcAHFeiZ1GNBaa47YDpfLAfh7uRm6BJO-LtVA41JOK82CyL_10X0qSFhaBs2fpYeSLqGJDJ5wWqjmhdZZL2ZcSJm3c6RsqcQDn7JmD8CgtNnmiAanSV0U6Gt8dZCFKglPLW3G00~2?test-tag=29",
            "https://yandex.ru/an/count/WXiejI_zOoVX2LdO0MqG09DTSYOQbKgbKga4mGHzFfSxUxRVkVDTNpjVl-FrXZjSPLCv-046UNLAVo55KasGEmmwZdxA5o1GMJpqjcnrjluC-AGgxalP2n5d-Qm0hRDSLe3MMIOhGEiiP2f0woJiKe3MIMWkGElCUN9RYZlp1V8eZ_t4SsTEGm2RRPND-PgG0WDa2tS33ZbTeHrIMwGX71cnc37ZUeCdnOiNCpXO6r5qMkosNL95RhmKU3mPSerDKf5oi_UKCEJafi3vVCFKGL4FqSQxBDi9hFBYaYW4wr2hOMyAmJhKQjXgfQnvlQ7j_T5mcoH9J6iw51avosK1R3605H6I1Me9XgpFKZNvkbBo9Qf8JvOUCsIoooqPNMQ74guOSZCFv647AN4X1KmtEm064wPsANgQUXIMx7rn04ssVZX5NVQ3AIn9yhyKbYJvNWfBadnkXKBmtn6G8lYr0-YT_Im2KWIPPfWkPfbertLTnzBc2KQkkh9qeuQhhJTwjmaJTAItE9trTOHS4hrvYUNB7joqQ3tPlpdvwl9ZseCDu27unVLV8YLuInxzbjPr_OeIl2MFNklD9lcAHFeiZ1GNBaa47YDpfLAfh7uRm6BJO-LtVA41JOK82CyL_10X0qSFhaBs2fpYeSLqGJDJ5wWqjmhdZZL2ZcSJm3c6RsqcQDn7JmD8CgtNnmiAanSV0U6Gt8dZCFKglPLW3G00~2?test-tag=29",
            "https://www.dovora.com/resources/weather-icons/showcase/modern_showcase/night_half_moon_partial_cloud.png",
            "https://www.dovora.com/resources/weather-icons/showcase/modern_showcase/night_half_moon_snow.png",
            "https://www.dovora.com/resources/weather-icons/showcase/modern_showcase/sleet.png",
            "https://www.dovora.com/resources/weather-icons/showcase/modern_showcase/mist.png",
            "https://www.dovora.com/resources/weather-icons/showcase/modern_showcase/night_full_moon_clear.png",
            "https://www.dovora.com/resources/weather-icons/showcase/modern_showcase/night_half_moon_rain.png",
            "https://www.dovora.com/resources/weather-icons/showcase/modern_showcase/rain_thunder.png",
            "https://www.dovora.com/resources/weather-icons/showcase/modern_showcase/fog.png",
            "https://www.dovora.com/resources/weather-icons/showcase/modern_showcase/angry_clouds.png",
            "https://www.dovora.com/resources/weather-icons/showcase/modern_showcase/day_clear.png",
            "https://www.dovora.com/resources/weather-icons/showcase/modern_showcase/night_half_moon_partial_cloud.png",
            "https://www.dovora.com/resources/weather-icons/showcase/modern_showcase/night_half_moon_snow.png",
            "https://www.dovora.com/resources/weather-icons/showcase/modern_showcase/sleet.png",
            "https://www.dovora.com/resources/weather-icons/showcase/modern_showcase/mist.png",
            "https://www.dovora.com/resources/weather-icons/showcase/modern_showcase/night_full_moon_clear.png",
            "https://www.dovora.com/resources/weather-icons/showcase/modern_showcase/night_half_moon_rain.png",
            "https://www.dovora.com/resources/weather-icons/showcase/modern_showcase/rain_thunder.png",
            "https://www.dovora.com/resources/weather-icons/showcase/modern_showcase/fog.png"

    };

    public OpticFragment() {
        // Required empty public constructor
    }


    public static OpticFragment newInstance() {
        OpticFragment fragment = new OpticFragment();

        return fragment;
    }
    private ArrayList<WeatherItem> generateData() {
        ArrayList<WeatherItem> list = new ArrayList<>();
        for(int i=0;i<image_names.length;i++) {
            list.add(new WeatherItem(image_names[i],image_urls[i]));
        }
        return list;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



    public class WeatherItem {
        private String name;
        private String url;

        public WeatherItem(String name, String url) {
            this.name = name;
            this.url = url;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        view=inflater.inflate(R.layout.fragment_optic, container, false);
        RecyclerView recyclerView =  view.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new MyAdapterOptic(generateData()));
        return view;
    }

}
