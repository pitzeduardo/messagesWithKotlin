package com.pitzdev.kotlinapi.repository

import com.pitzdev.kotlinapi.model.holder.Holder
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface HolderRepository : CrudRepository<Holder, Long>