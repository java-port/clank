/**
 * This file was converted to Java from the original LLVM source file. The original
 * source file follows the LLVM Release License, outlined below.
 * 
 * ==============================================================================
 * LLVM Release License
 * ==============================================================================
 * University of Illinois/NCSA
 * Open Source License
 * 
 * Copyright (c) 2003-2017 University of Illinois at Urbana-Champaign.
 * All rights reserved.
 * 
 * Developed by:
 * 
 *     LLVM Team
 * 
 *     University of Illinois at Urbana-Champaign
 * 
 *     http://llvm.org
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal with
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimers.
 * 
 *     * Redistributions in binary form must reproduce the above copyright notice
 *       this list of conditions and the following disclaimers in the
 *       documentation and/or other materials provided with the distribution.
 * 
 *     * Neither the names of the LLVM Team, University of Illinois at
 *       Urbana-Champaign, nor the names of its contributors may be used to
 *       endorse or promote products derived from this Software without specific
 *       prior written permission.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS WITH THE
 * SOFTWARE.
 * 
 * ==============================================================================
 * Copyrights and Licenses for Third Party Software Distributed with LLVM:
 * ==============================================================================
 * The LLVM software contains code written by third parties.  Such software will
 * have its own individual LICENSE.TXT file in the directory in which it appears.
 * This file will describe the copyrights, license, and restrictions which apply
 * to that code.
 * 
 * The disclaimer of warranty in the University of Illinois Open Source License
 * applies to all code in the LLVM Distribution, and nothing in any of the
 * other licenses gives permission to use the names of the LLVM Team or the
 * University of Illinois to endorse or promote products derived from this
 * Software.
 * 
 * The following pieces of software have additional or alternate copyrights,
 * licenses, and/or restrictions:
 * 
 * Program             Directory
 * -------             ---------
 * Autoconf            llvm/autoconf
 *                     llvm/projects/ModuleMaker/autoconf
 * Google Test         llvm/utils/unittest/googletest
 * OpenBSD regex       llvm/lib/Support/{reg*, COPYRIGHT.regex}
 * pyyaml tests        llvm/test/YAMLParser/{*.data, LICENSE.TXT}
 * ARM contributions   llvm/lib/Target/ARM/LICENSE.TXT
 * md5 contributions   llvm/lib/Support/MD5.cpp llvm/include/llvm/Support/MD5.h
 */

package org.clang.driver;

import java.util.Iterator;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.driver.*;


/// JobList - A sequence of jobs to perform.
//<editor-fold defaultstate="collapsed" desc="clang::driver::JobList">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*implement Iterator<Command>*/,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Job.h", line = 156,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Job.h", old_line = 142,
 FQN="clang::driver::JobList", NM="_ZN5clang6driver7JobListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp -nm=_ZN5clang6driver7JobListE")
//</editor-fold>
public class JobList implements Destructors.ClassWithDestructor, Iterable<Command> {
/*public:*/
  /*typedef SmallVector<std::unique_ptr<Command>, 4> list_type*/
//  public final class list_type extends SmallVector<std.unique_ptr<Command>>{ };
  /*typedef list_type::size_type size_type*/;
  /*typedef llvm::pointee_iterator<list_type::iterator> iterator*/
//  public final class iterator extends pointee_iterator<unique_ptr<Command> /*P*/>{ };
  /*typedef llvm::pointee_iterator<list_type::const_iterator> const_iterator*/
//  public final class const_iterator extends pointee_iterator</*const*/unique_ptr<Command> /*P*/>{ };
/*private:*/
  private SmallVector<std.unique_ptr<Command>> Jobs;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::JobList::Print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Job.cpp", line = 336,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Job.cpp", old_line = 300,
   FQN="clang::driver::JobList::Print", NM="_ZNK5clang6driver7JobList5PrintERN4llvm11raw_ostreamEPKcbPNS0_15CrashReportInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Job.cpp -nm=_ZNK5clang6driver7JobList5PrintERN4llvm11raw_ostreamEPKcbPNS0_15CrashReportInfoE")
  //</editor-fold>
  public void Print(raw_ostream /*&*/ OS, /*const*/char$ptr/*char P*/ Terminator, boolean Quote) /*const*/ {
    Print(OS, Terminator, Quote, 
       (CrashReportInfo /*P*/ )null);
  }
  public void Print(raw_ostream /*&*/ OS, /*const*/char$ptr/*char P*/ Terminator, boolean Quote, 
       CrashReportInfo /*P*/ CrashInfo/*= null*/) /*const*/ {
    for (/*const*/ Command /*&*/ Job : /*Deref*/this)  {
      Job.Print(OS, Terminator, Quote, CrashInfo);
    }
  }


  
  /// Add a job to the list (taking ownership).
  //<editor-fold defaultstate="collapsed" desc="clang::driver::JobList::addJob">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Job.h", line = 171,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Job.h", old_line = 157,
   FQN="clang::driver::JobList::addJob", NM="_ZN5clang6driver7JobList6addJobESt10unique_ptrINS0_7CommandESt14default_deleteIS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp -nm=_ZN5clang6driver7JobList6addJobESt10unique_ptrINS0_7CommandESt14default_deleteIS3_EE")
  //</editor-fold>
  public void addJob(std.unique_ptr<Command> J) {
    Jobs.push_back_T$RR(std.move(J));
  }

  
  /// Clear the job list.
  
  /// Clear the job list.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::JobList::clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Job.cpp", line = 342,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Job.cpp", old_line = 306,
   FQN="clang::driver::JobList::clear", NM="_ZN5clang6driver7JobList5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Job.cpp -nm=_ZN5clang6driver7JobList5clearEv")
  //</editor-fold>
  public void clear() {
    Jobs.clear();
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::JobList::getJobs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Job.h", line = 176,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Job.h", old_line = 162,
   FQN="clang::driver::JobList::getJobs", NM="_ZNK5clang6driver7JobList7getJobsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp -nm=_ZNK5clang6driver7JobList7getJobsEv")
  //</editor-fold>
  public /*const*/SmallVector<std.unique_ptr<Command>> /*&*/ getJobs() /*const*/ {
    return Jobs;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::JobList::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Job.h", line = 178,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Job.h", old_line = 164,
   FQN="clang::driver::JobList::size", NM="_ZNK5clang6driver7JobList4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp -nm=_ZNK5clang6driver7JobList4sizeEv")
  //</editor-fold>
  public /*size_t*/int size() /*const*/ {
    return Jobs.size();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::JobList::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Job.h", line = 179,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Job.h", old_line = 165,
   FQN="clang::driver::JobList::begin", NM="_ZN5clang6driver7JobList5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp -nm=_ZN5clang6driver7JobList5beginEv")
  //</editor-fold>
  public type$iterator<?, Command /*P*/> begin() {
    return new pointee_iterator_unique_ptr<Command>(Jobs.begin());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::JobList::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Job.h", line = 180,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Job.h", old_line = 166,
   FQN="clang::driver::JobList::begin", NM="_ZNK5clang6driver7JobList5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp -nm=_ZNK5clang6driver7JobList5beginEv")
  //</editor-fold>
  public type$iterator<?, Command /*P*/> begin$Const() /*const*/ {
    return new pointee_iterator_unique_ptr<Command>(Jobs.begin$Const());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::JobList::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Job.h", line = 181,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Job.h", old_line = 167,
   FQN="clang::driver::JobList::end", NM="_ZN5clang6driver7JobList3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp -nm=_ZN5clang6driver7JobList3endEv")
  //</editor-fold>
  public type$iterator<?, Command /*P*/> end() {
    return new pointee_iterator_unique_ptr<Command>(Jobs.end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::JobList::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Job.h", line = 182,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Job.h", old_line = 168,
   FQN="clang::driver::JobList::end", NM="_ZNK5clang6driver7JobList3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp -nm=_ZNK5clang6driver7JobList3endEv")
  //</editor-fold>
  public type$iterator<?, Command /*P*/> end$Const() /*const*/ {
    return new pointee_iterator_unique_ptr<Command>(Jobs.end$Const());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::JobList::~JobList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Job.h", line = 156,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Job.h", old_line = 142,
   FQN="clang::driver::JobList::~JobList", NM="_ZN5clang6driver7JobListD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp -nm=_ZN5clang6driver7JobListD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Jobs.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::JobList::JobList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Job.h", line = 156,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Job.h", old_line = 142,
   FQN="clang::driver::JobList::JobList", NM="_ZN5clang6driver7JobListC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Compilation.cpp -nm=_ZN5clang6driver7JobListC1Ev")
  //</editor-fold>
  public /*inline*/ JobList() {
    // : Jobs() 
    //START JInit
    this.Jobs = new SmallVector<std.unique_ptr<Command>>(4, new std.unique_ptr<Command>());
    //END JInit
  }

  @Override
  public Iterator<Command> iterator() {
    return new JobListIterator(begin(), end());
  }
  
  private static class JobListIterator implements Iterator<Command> {

    private type$iterator<?, Command> beginIter;

    private final type$iterator<?, Command> endIter;

    public JobListIterator(type$iterator<?, Command> beginIter, type$iterator<?, Command> endIter) {
      this.beginIter = $tryClone(beginIter);
      this.endIter = endIter;
    }

    @Override
    public boolean hasNext() {
      return beginIter.$noteq(endIter);
    }

    @Override
    public Command next() {
      Command val = beginIter.$star();
      beginIter.$preInc();
      return val;
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException("Not supported.");
    }
  }
  
  @Override public String toString() {
    return "" + "Jobs=" + Jobs; // NOI18N
  }
}
