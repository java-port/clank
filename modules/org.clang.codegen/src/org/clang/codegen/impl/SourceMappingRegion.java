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

package org.clang.codegen.impl;

import org.clank.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.llvm.profiledata.coverage.*;
import org.clang.codegen.impl.*;


/// \brief A region of source code that can be mapped to a counter.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SourceMappingRegion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 38,
 FQN="(anonymous namespace)::SourceMappingRegion", NM="_ZN12_GLOBAL__N_119SourceMappingRegionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_119SourceMappingRegionE")
//</editor-fold>
public class SourceMappingRegion implements Destructors.ClassWithDestructor {
  private Counter Count;
  
  /// \brief The region's starting location.
  private Optional<SourceLocation> LocStart;
  
  /// \brief The region's ending location.
  private Optional<SourceLocation> LocEnd;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SourceMappingRegion::SourceMappingRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 48,
   FQN="(anonymous namespace)::SourceMappingRegion::SourceMappingRegion", NM="_ZN12_GLOBAL__N_119SourceMappingRegionC1EN4llvm8coverage7CounterENS1_8OptionalIN5clang14SourceLocationEEES7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_119SourceMappingRegionC1EN4llvm8coverage7CounterENS1_8OptionalIN5clang14SourceLocationEEES7_")
  //</editor-fold>
  public SourceMappingRegion(Counter Count, Optional<SourceLocation> LocStart, 
      Optional<SourceLocation> LocEnd) {
    // : Count(Count), LocStart(LocStart), LocEnd(LocEnd) 
    //START JInit
    this.Count = new Counter(Count);
    this.LocStart = new Optional<SourceLocation>(LocStart);
    this.LocEnd = new Optional<SourceLocation>(LocEnd);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SourceMappingRegion::getCounter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 52,
   FQN="(anonymous namespace)::SourceMappingRegion::getCounter", NM="_ZNK12_GLOBAL__N_119SourceMappingRegion10getCounterEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZNK12_GLOBAL__N_119SourceMappingRegion10getCounterEv")
  //</editor-fold>
  public /*const*/ Counter /*&*/ getCounter() /*const*/ {
    return Count;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SourceMappingRegion::setCounter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 54,
   FQN="(anonymous namespace)::SourceMappingRegion::setCounter", NM="_ZN12_GLOBAL__N_119SourceMappingRegion10setCounterEN4llvm8coverage7CounterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_119SourceMappingRegion10setCounterEN4llvm8coverage7CounterE")
  //</editor-fold>
  public void setCounter(Counter C) {
    Count.$assign(C);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SourceMappingRegion::hasStartLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 56,
   FQN="(anonymous namespace)::SourceMappingRegion::hasStartLoc", NM="_ZNK12_GLOBAL__N_119SourceMappingRegion11hasStartLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZNK12_GLOBAL__N_119SourceMappingRegion11hasStartLocEv")
  //</editor-fold>
  public boolean hasStartLoc() /*const*/ {
    return LocStart.hasValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SourceMappingRegion::setStartLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 58,
   FQN="(anonymous namespace)::SourceMappingRegion::setStartLoc", NM="_ZN12_GLOBAL__N_119SourceMappingRegion11setStartLocEN5clang14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_119SourceMappingRegion11setStartLocEN5clang14SourceLocationE")
  //</editor-fold>
  public void setStartLoc(SourceLocation Loc) {
    LocStart.$assign_T$C$R(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SourceMappingRegion::getStartLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 60,
   FQN="(anonymous namespace)::SourceMappingRegion::getStartLoc", NM="_ZNK12_GLOBAL__N_119SourceMappingRegion11getStartLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZNK12_GLOBAL__N_119SourceMappingRegion11getStartLocEv")
  //</editor-fold>
  public SourceLocation getStartLoc() /*const*/ {
    assert (LocStart.$bool()) : "Region has no start location";
    return new SourceLocation(LocStart.$star$Const());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SourceMappingRegion::hasEndLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 65,
   FQN="(anonymous namespace)::SourceMappingRegion::hasEndLoc", NM="_ZNK12_GLOBAL__N_119SourceMappingRegion9hasEndLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZNK12_GLOBAL__N_119SourceMappingRegion9hasEndLocEv")
  //</editor-fold>
  public boolean hasEndLoc() /*const*/ {
    return LocEnd.hasValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SourceMappingRegion::setEndLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 67,
   FQN="(anonymous namespace)::SourceMappingRegion::setEndLoc", NM="_ZN12_GLOBAL__N_119SourceMappingRegion9setEndLocEN5clang14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_119SourceMappingRegion9setEndLocEN5clang14SourceLocationE")
  //</editor-fold>
  public void setEndLoc(SourceLocation Loc) {
    LocEnd.$assign_T$C$R(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SourceMappingRegion::getEndLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 69,
   FQN="(anonymous namespace)::SourceMappingRegion::getEndLoc", NM="_ZNK12_GLOBAL__N_119SourceMappingRegion9getEndLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZNK12_GLOBAL__N_119SourceMappingRegion9getEndLocEv")
  //</editor-fold>
  public SourceLocation getEndLoc() /*const*/ {
    assert (LocEnd.$bool()) : "Region has no end location";
    return new SourceLocation(LocEnd.$star$Const());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SourceMappingRegion::~SourceMappingRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 38,
   FQN="(anonymous namespace)::SourceMappingRegion::~SourceMappingRegion", NM="_ZN12_GLOBAL__N_119SourceMappingRegionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_119SourceMappingRegionD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    LocEnd.$destroy();
    LocStart.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SourceMappingRegion::SourceMappingRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp", line = 38,
   FQN="(anonymous namespace)::SourceMappingRegion::SourceMappingRegion", NM="_ZN12_GLOBAL__N_119SourceMappingRegionC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CoverageMappingGen.cpp -nm=_ZN12_GLOBAL__N_119SourceMappingRegionC1ERKS0_")
  //</editor-fold>
  public /*inline*/ SourceMappingRegion(final /*const*/ SourceMappingRegion /*&*/ $Prm0) {
    // : Count(.Count), LocStart(.LocStart), LocEnd(.LocEnd) 
    //START JInit
    this.Count = new Counter($Prm0.Count);
    this.LocStart = new Optional<SourceLocation>($Prm0.LocStart);
    this.LocEnd = new Optional<SourceLocation>($Prm0.LocEnd);
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  SourceMappingRegion(Counter counter, SourceLocation NestedLoc, SourceLocation EndLoc) {
    this.Count = new Counter(Count);
    this.LocStart = Optional.<SourceLocation>create(NestedLoc);
    this.LocEnd = Optional.<SourceLocation>create(EndLoc);
  }

  public SourceMappingRegion() {
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Count=" + Count // NOI18N
              + ", LocStart=" + LocStart // NOI18N
              + ", LocEnd=" + LocEnd; // NOI18N
  }
}
