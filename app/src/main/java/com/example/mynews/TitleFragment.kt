package com.example.mynews

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TitleFragment : Fragment() {

    private val newsList = mutableListOf<NewsItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 더미 데이터 만들기
        newsList.add(NewsItem("뉴욕증시, 국제유가 상승에 하락…다우 0.56%↓ 마감", "(뉴욕=연합뉴스) 정선영 연합인포맥스 특파원 = 뉴욕증시는 유가 상승에 따른 인플레이션 부담과 미 연방준비제도(Fed·연준) 긴축 정책이 지속될 수 있다는 우려에 하락했다.",R.drawable.sample1))
        newsList.add(NewsItem("김정은, 딸 주애와 열병식 참석…연설 안해", "[데일리한국 천소진 기자] 김정은 북한 국무위원장이 정권수립(9·9절) 75주년을 맞아 열린 '민방위 무력 열병식'에 참석했으나 연설은 하지 않은 것으로 드러났다.",R.drawable.sample1))
        newsList.add(NewsItem("청양고추 220배 매운맛 과자 먹은 10대 사망", "【서울=뉴시스】김찬호 리포터 = 미국에서 유행하고 있는 '원칩 챌린지'에 도전한 한 10대 소년이 사망했다. 정확한 사인은 아직 드러나지 않았으나, 소년의 가족들은 이 챌린지 때문이라고 보고 있다.\n",R.drawable.sample1))
        newsList.add(NewsItem("No탕후루존 등장…\"끈적거리고 벌레 꼬여\"", "[서울=뉴시스]김래현 기자 = \"요새 노(NO) 탕후루존이라고 꼬치를 못 들고 들어오게 하는 곳도 있다는데 이해가 돼요. 먹었으면 뒤처리까지 깔끔하게 해야죠\"",R.drawable.sample1))
        newsList.add(NewsItem("미코 출신 특전사 장교, 군복 벗고 AG 금메달 겨눈다", "이번 항저우 아시안게임에 출전하는 한 여자 국가대표 선수가 화제를 모으고 있습니다.",R.drawable.sample1))
        newsList.add(NewsItem("\"'삐빅' 찍지 마세요\"…교통카드 안 찍고 지하철 탄다", "앞으로 일부 지하철역에서는 '삐빅' 교통카드를 찍지 않고 지하철 게이트를 지나가기만 하면 자동 결제돼 지하철을 탈 수 있습니다.\n",R.drawable.sample1))

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?    ): View? {
        val view = inflater.inflate(R.layout.fragment_title, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)

        val adapter = NewsAdapter(newsList) { selectedNewsItem ->
            val detailFragment = DetailFragment()
            val bundle = Bundle()
            bundle.putString("articleDetail", selectedNewsItem.article)
            bundle.putInt("imgDetail", selectedNewsItem.img)
            detailFragment.arguments = bundle

            val fragmentManager = requireActivity().supportFragmentManager
            val transaction = fragmentManager.beginTransaction()

            transaction.replace(R.id.fragmentContainer, detailFragment)
            transaction.addToBackStack(null)

            transaction.commit()
        }

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        return view
    }
}