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
            "В оптике изучаются световые явления — явления, которые происходят со светом. Они не являются специфическими только для света, а наблюдаются у волн самой разной природы. Большинство из них описаны в теме «Механические колебания и волны (статья Волновые явления»).",
            "Интерференция света — физическое явление сложения когерентных световых волн, при котором наблюдается устойчивое пространственное перераспределение интенсивности света в виде темных и светлых полос (интерференционная картина)",
            "Интерференция в тонких пленках — интерференция, возникающая при падении света на тонкие прозрачные пленки (мыльную, бензиновую и др.).Когерентные волны накладываются друг на друга, в результате чего образуется интерференционная картина в отраженном свете. При освещении пленки монохроматическим светом она имеет вид темных и светлых полос, а при освещении белым светом пленки приобретают радужную окраску, поскольку максимумы интенсивности для разных длин волн наблюдаются в разных местах пленки.",
            "Кольца Ньютона —  интерференционная картина, которая имеет вид концентрических колец и возникает при освещении светом установки.Когерентные волны накладываются друг на друга, в результате чего вблизи точки касания линзы и пластины образуется интерференционная картина в отражённом свете. Радиус колец Ньютона разный для света разного цвета. Так, верхняя часть a соответствует освещению установки зелёным светом, а нижняя часть — красным",
            "Дифракция света — физическое явление огибания световыми волнами препятствий (отклонение от законов геометрической оптики). По типу препятствий различают дифракцию на щели, на отверстии, на малом круглом препятствии и др. На экране, помещенном за препятствием, можно наблюдать чередование освещенных и темных участков — дифракционную картину. Для расчета дифракционной картины, т. е. положения этих участков (полос), применяют принцип Гюйгенса-Френеля.",
            "Отражение света — возвращение световой волны в первую среду при ее падении на поверхность раздела двух сред.",
            "Зеркальное отражение — отражение от гладких поверхностей. Падающий парал ельный пучок лучей остается параллельным и после отражения.",
            "Диффузное отражение — отражение от шероховатых поверхностей. Шероховатая (негладкая) поверхность рассеивает свет: отражает падающий параллельный пучок лучей по всем направлениям.",
            "Преломление света — изменение направления световой волны при переходе через границу раздела двух прозрачных сред.",
            "Полное внутреннее отражение (полное отражение света) — явление отражения света от границы раздела двух прозрачных сред, при котором свет полностью отражается (отсутствуют преломленные лучи).",
            "Дисперсия света — физическое явление, заключающееся\n" +
                    "в том, что световые пучки разного цвета (т. е. имеющие разную частоту ν и длину волны λ) при переходе через границу раздели двух сред преломляются по-разному. В результате дисперсии белый свет, пройдя через стеклянную призму, разлагается в спектр. Дисперсия света объясняется тем, что скорость распространения света в среде и, следовательно, абсолютный показатель преломления среды, зависит от длины волны λ (частоты ν) света: n = c/v, где v = v(λ).",
            "Поглощение света — уменьшение интенсивности световой волны при ее распространении в веществе. Объясняется взаимодействием света с атомами вещества.",
            "Поляризация света — физическое явление, при котором естественный свет преобразуется в поляризованный (направление колебаний светового вектора Е становится упорядоченным). В случае преобразования света в плоскополяризованный можно говорить, что поляризация есть выделение определенного направления колебаний светового вектора E. Поляризатор преобразует естественный свет в поляризованный, а анализатор позволяет определить, действительно ли свет поляризован (если при вращении анализатора, интенсивность света, прошедшего через него меняется, это означает, что свет поляризован). Явление поляризации света свидетельствует о волновой природе света, а также о том, что свет является поперечной волной.",
            "Рассеяние света —отклонение световых лучей во всевозможных направлениях от первоначального. Рассеяние света возникает в тех случаях, когда среда, в которой распространяется свет, является оптически неоднородной."
    };

    private final String[] image_urls = {
            "https://basinreboot.com/wp-content/uploads/2021/11/clipping-path-company.jpg",
            "https://images.csmonitor.com/csmarchives/2010/06/0609-bubble-science.jpg?alias=standard_900x600",
            "https://i.ytimg.com/vi/T_OnzBJFxh0/hqdefault.jpg",
            "https://shareslide.ru/img/thumbs/3bae2b4d0d847f65031c35aba4faebec-800x.jpg",
            "https://static-3.bitchute.com/live/cover_images/F2O8X74euP0g/BZRUqrrRCBa6_640x360.jpg",
            "https://1posvetu.ru/wp-content/uploads/2016/09/Reflection-of-light.jpg",
            "https://webpulse.imgsmail.ru/imgpreview?mb=webpulse&key=pulse_cabinet-image-6f796ae6-53f8-44e7-858b-16636c145881",
            "https://myslide.ru/documents_7/70298b615b4fe00e23512bccfa5e8aae/img9.jpg",
            "https://rusinfo.info/wp-content/uploads/8/9/f/89fbdbd622c3d34cae2d6593ddf5a594.jpg",
            "https://cf2.ppt-online.org/files2/slide/p/pXQx3a8NWjkgmfylTF2ePDvML5YdRBAtunCb9V/slide-59.jpg",
            "https://cknow.ru/uploads/posts/2018-02/1519396971_snimok.jpg",
            "https://cf.ppt-online.org/files1/slide/o/O38QKMbrukhcg5f1PnNRlISaCBF2vx9DsUdEzAeiG/slide-6.jpg",
            "https://sun9-20.userapi.com/impg/lYwgwHsZdwJhUelTZqIjSGGampg9ogqHqc6Uzw/ITIvR5pciUc.jpg?size=604x453&quality=96&sign=aa8b11e204fb906905df5bd9c1ec3014&type=album",
            "https://cf.ppt-online.org/files1/slide/o/O38QKMbrukhcg5f1PnNRlISaCBF2vx9DsUdEzAeiG/slide-35.jpg"


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
