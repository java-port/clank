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

package org.llvm.support.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.llvm.support.*;
import org.llvm.adt.*;

/// StatisticInfo - This class is used in a ManagedStatic so that it is created
/// on demand (when the first statistic is bumped) and destroyed only when
/// llvm_shutdown is called.  We print statistics from the destructor.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StatisticInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Statistic.cpp", line = 53,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Statistic.cpp", old_line = 50,
 FQN="(anonymous namespace)::StatisticInfo", NM="_ZN12_GLOBAL__N_113StatisticInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Statistic.cpp -nm=_ZN12_GLOBAL__N_113StatisticInfoE")
//</editor-fold>
public class StatisticInfo implements Destructors.ClassWithDestructor {
  /*friend*/public std.vector</*const*/ Statistic /*P*/ > Stats;
  /*friend void PrintStatistics()*/
  /*friend void PrintStatistics(raw_ostream &OS)*/
  /*friend void PrintStatisticsJSON(raw_ostream &OS)*/
  
  /// Sort statistics by debugtype,name,description.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StatisticInfo::sort">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/Statistic.cpp", line = 105,
   FQN="(anonymous namespace)::StatisticInfo::sort", NM="_ZN12_GLOBAL__N_113StatisticInfo4sortEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Statistic.cpp -nm=_ZN12_GLOBAL__N_113StatisticInfo4sortEv")
  //</editor-fold>
  /*friend*/public void sort() {
    std.stable_sort(Stats.begin(), Stats.end(), 
        /*[]*/ (/*const*/ Statistic /*P*/ LHS, /*const*/ Statistic /*P*/ RHS) -> {
              {
                int Cmp = std.strcmp(LHS.getDebugType(), RHS.getDebugType());
                if ((Cmp != 0)) {
                  return Cmp < 0;
                }
              }
              {
                
                int Cmp = std.strcmp(LHS.getName(), RHS.getName());
                if ((Cmp != 0)) {
                  return Cmp < 0;
                }
              }
              
              return std.strcmp(LHS.getDesc(), RHS.getDesc()) < 0;
            });
  }

/*public:*/
  
  // Print information when destroyed, iff command line option is specified.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StatisticInfo::~StatisticInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/Statistic.cpp", line = 93,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Statistic.cpp", old_line = 86,
   FQN="(anonymous namespace)::StatisticInfo::~StatisticInfo", NM="_ZN12_GLOBAL__N_113StatisticInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Statistic.cpp -nm=_ZN12_GLOBAL__N_113StatisticInfoD0Ev")
  //</editor-fold>
  public void $destroy() {
    llvm.PrintStatistics();
    //START JDestroy
    Stats.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StatisticInfo::addStatistic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/Statistic.cpp", line = 64,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Statistic.cpp", old_line = 57,
   FQN="(anonymous namespace)::StatisticInfo::addStatistic", NM="_ZN12_GLOBAL__N_113StatisticInfo12addStatisticEPKN4llvm9StatisticE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Statistic.cpp -nm=_ZN12_GLOBAL__N_113StatisticInfo12addStatisticEPKN4llvm9StatisticE")
  //</editor-fold>
  public void addStatistic(/*const*/ Statistic /*P*/ S) {
    Stats.push_back_T$C$R(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StatisticInfo::StatisticInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/Statistic.cpp", line = 53,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Statistic.cpp", old_line = 50,
   FQN="(anonymous namespace)::StatisticInfo::StatisticInfo", NM="_ZN12_GLOBAL__N_113StatisticInfoC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Statistic.cpp -nm=_ZN12_GLOBAL__N_113StatisticInfoC1Ev")
  //</editor-fold>
  public /*inline*/ StatisticInfo() {
    // : Stats() 
    //START JInit
    this.Stats = new std.vector</*const*/ Statistic /*P*/ >((Statistic/*P*/)null);
    //END JInit
  }


  @Override public String toString() {
    return "" + "Stats=" + Stats; // NOI18N
  }
}
