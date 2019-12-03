package com.framblestd.loonatheapp.activities

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.framblestd.loonatheapp.models.member.Member
import com.framblestd.loonatheapp.models.member.MemberRepository
import com.framblestd.loonatheapp.R

class MemberDetailsActivity : AppCompatActivity() {

    private lateinit var ivMemberPicture: ImageView
    private lateinit var tvMemberName: TextView
    private lateinit var tvMemberRealName: TextView
    private lateinit var tvMemberBirthDate: TextView
    private lateinit var tvMemberDebutDate: TextView
    private lateinit var tvMemberSubUnit: TextView
    private lateinit var tvMemberAnimal: TextView
    private lateinit var member: Member

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_member_details)

        ivMemberPicture = findViewById(R.id.iv_member_picture)
        tvMemberName = findViewById(R.id.tv_member_name)
        tvMemberRealName = findViewById(R.id.tv_member_real_name)
        tvMemberBirthDate = findViewById(R.id.tv_member_birth_date)
        tvMemberDebutDate = findViewById(R.id.tv_member_debut_date)
        tvMemberSubUnit = findViewById(R.id.tv_member_subunit)
        tvMemberAnimal = findViewById(R.id.tv_member_animal_representation)

        fetchMemberFromRepository()
        displayMemberToView()
        setupActionBar()
    }

    private fun setupActionBar() {
        title = member.name
        supportActionBar?.run {
            setBackgroundDrawable(ColorDrawable(member.officialColor))
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setDisplayShowTitleEnabled(false)
            setDisplayShowTitleEnabled(true)
        }
    }

    private fun fetchMemberFromRepository() {
        val memberId = intent.getIntExtra(EXTRA_MEMBER_ID, 0)
        val member = MemberRepository.findById(memberId)

        if (member != null) {
            this.member = member
        }
    }

    private fun displayMemberToView() {
        Glide.with(this)
            .load(member.picture)
            .into(ivMemberPicture)

        tvMemberName.text = member.name
        tvMemberRealName.text = member.realName
        tvMemberBirthDate.text = member.birthDate
        tvMemberDebutDate.text = member.debutDate
        tvMemberSubUnit.text = member.subUnit
        tvMemberAnimal.text = member.animalRepresentation
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }

        return true
    }

    companion object {
        const val EXTRA_MEMBER_ID = "extra_member_id"
    }
}
