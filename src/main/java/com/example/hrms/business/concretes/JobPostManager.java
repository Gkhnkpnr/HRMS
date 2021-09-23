package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.JobPostService;
import com.example.hrms.core.dtoConverter.DtoConverterService;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.dataAccess.abstracts.JobPostDao;
import com.example.hrms.entities.concretes.JobPost;
import com.example.hrms.entities.dtos.addDtos.JobPostAddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPostManager implements JobPostService {

    private final JobPostDao jobPostDao;
    private final DtoConverterService dtoConverterService;

    @Autowired
    public JobPostManager(JobPostDao jobPostDao, DtoConverterService dtoConverterService) {
        this.jobPostDao = jobPostDao;
        this.dtoConverterService = dtoConverterService;
    }

    @Override
    public DataResult<List<JobPost>> getAllJobPosts() {
        if ((long) this.jobPostDao.findAll().size() >0){
            return new SuccessDataResult<>(this.jobPostDao.findAll(), "Tüm iş ilanları listelendi.");
        }
        return new WarningDataResult<>(this.jobPostDao.findAll(), "Listelenecek İş ilanı bulunamadı");
    }

    @Override
    public DataResult<List<JobPost>> getSortedJobPosts() {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        return new SuccessDataResult<>(this.jobPostDao.findAll(sort), "iş ilanları listelendi.");
    }

    @Override
    public DataResult<List<JobPost>> getActiveJobPosts() {
        if ((long) this.jobPostDao.findAllByIsActiveTrue().size() >0){
            return new SuccessDataResult<>(this.jobPostDao.findAllByIsActiveTrue(), "Aktif tüm iş ilanları listelendi.");
        }
        return new WarningDataResult<>(this.jobPostDao.findAllByIsActiveTrue(), "Aktif iş ilanları bulunamadı");
    }

    @Override
    public DataResult<List<JobPost>> getJobPostByCompanyName(String companyName) {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        if ((long) jobPostDao.getJobPostByEmployer_CompanyName(companyName, sort).size() > 0 ){
            return new SuccessDataResult<>(this.jobPostDao.getJobPostByEmployer_CompanyName(companyName, sort), "Şirkete ait tüm ilanlar listelendi.");
        }
        return new WarningDataResult<>(this.jobPostDao.getJobPostByEmployer_CompanyName(companyName, sort), "Şirkete ait iş ilanı bulunamadı.");
    }

    @Override
    public DataResult<List<JobPost>> findAllByIsActiveTrue(boolean isDesc) {
        Sort sort;
        if (isDesc){
            sort = Sort.by(Sort.Direction.DESC, "airdate");
        }else{
            sort = Sort.by(Sort.Direction.ASC, "airdate");
        }

        if ((long) this.jobPostDao.findAllByIsActiveTrue(sort).size()>0){
            return new SuccessDataResult<>(this.jobPostDao.findAllByIsActiveTrue(sort), "Aktif iş ilanları yayınlama tarihine göre sıralandı");
        }
        return new WarningDataResult<>(this.jobPostDao.findAllByIsActiveTrue(sort), "Aktif iş ilanı bulunamadı");
    }

    @Override
    public DataResult<List<JobPost>> getJobPostByIsActiveTrueAndIsConfirmedTrueByPageDesc(int pageNo, int pageSize) {
        Sort sort;
        sort = Sort.by(Sort.Direction.DESC, "airdate");
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        if (this.jobPostDao.getJobPostByIsActiveTrueAndIsConfirmedTrue(pageable).size()>0){
            return new SuccessDataResult<>(this.jobPostDao.getJobPostByIsActiveTrueAndIsConfirmedTrue(pageable), "Onaylı ve Aktif iş ilanları yayınlanma tarihine göre azalarak sıralandı");
        }
        return new WarningDataResult<>(this.jobPostDao.getJobPostByIsActiveTrueAndIsConfirmedTrue(pageable),"Onaylı ve Aktif iş ilanı bulunamadı");
    }

    @Override
    public DataResult<List<JobPost>> getJobPostByIsActiveTrueAndIsConfirmedTrueByPageAsc(int pageNo, int pageSize) {
        Sort sort;
        sort = Sort.by(Sort.Direction.ASC, "airdate");
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        if (this.jobPostDao.getJobPostByIsActiveTrueAndIsConfirmedTrue(pageable).size() >0 ){
            return new SuccessDataResult<>(this.jobPostDao.getJobPostByIsActiveTrueAndIsConfirmedTrue(pageable), "Onaylı ve Aktif iş ilanları yayınlanma tarihlerine göre artan şekilde listelendi.");
        }
        return new WarningDataResult<>(this.jobPostDao.getJobPostByIsActiveTrueAndIsConfirmedTrue(pageable), "Onaylı ve Aktif iş ilanı bulunamadı");
    }

    @Override
    public DataResult<List<JobPost>> getJobPostByIsActiveTrueAndIsConfirmedTrue() {
        if (this.jobPostDao.getJobPostIsActiveTrueAndIsConfirmedTrue().size()>0){
            return new SuccessDataResult<>(this.jobPostDao.getJobPostIsActiveTrueAndIsConfirmedTrue(),"Onaylı ve Aktif iş ilanları listelendi");
        }
        return new WarningDataResult<>(this.jobPostDao.getJobPostIsActiveTrueAndIsConfirmedTrue(),"Onaylı ve Aktif iş ilanları bulunamadı");
    }

    @Override
    public DataResult<JobPost> getJobPostById(int jobPostId) {
        if (this.jobPostDao.getJobPostById(jobPostId) == null){
            return new WarningDataResult<>("Kayıtlı iş ilanı bulunamadı");
        }
        return new SuccessDataResult<>(this.jobPostDao.getJobPostById(jobPostId),"İş ilanları listelendi.");
    }

    @Override
    public DataResult<List<JobPost>> getJobPostByEmployerId(int employerId) {
        Sort sort = Sort.by(Sort.Direction.ASC, "isConfirmed", "id");
        if ((long) this.jobPostDao.getJobPostByEmployerId(employerId, sort).size()>0){
            return new SuccessDataResult<>(jobPostDao.getJobPostByEmployerId(employerId, sort), "Şirkete ait ilanlar listelendi");
        }
        return new WarningDataResult<>(this.jobPostDao.getJobPostByEmployerId(employerId, sort), "Şirkete ait ilan bulunamadı");
    }

    @Override
    public Result changeIsActive(boolean active, int jobPostId) {
        this.jobPostDao.changeIsActive(active, jobPostId);
        return new SuccessResult("İlan aktiflik durumu değiştirildi");
    }

    @Override
    public Result changeIsConfirmed(boolean confirmed, int jobPostId) {
        this.jobPostDao.changeIsConfirmed(confirmed, jobPostId);
        return new SuccessResult("İlan doğrulanma durumu değiştirildi");
    }

    @Override
    public Result addJobPost(JobPostAddDto jobPost) {
        this.jobPostDao.save((JobPost) this.dtoConverterService.dtoClassConverter(jobPost, JobPostAddDto.class));
        return new SuccessResult("İlan sisteme eklendi");
    }

    @Override
    public Result deleteJobPostById(int jobPostId) {
        this.jobPostDao.deleteByJobPostById(jobPostId);
        return new SuccessResult("İş İlanı silindi.");
    }
}
