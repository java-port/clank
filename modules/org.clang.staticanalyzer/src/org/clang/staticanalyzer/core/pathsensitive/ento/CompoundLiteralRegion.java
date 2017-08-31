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

package org.clang.staticanalyzer.core.pathsensitive.ento;

import org.clank.support.*;
import static org.clank.support.Casts.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;


/// CompoundLiteralRegion - A memory region representing a compound literal.
///   Compound literals are essentially temporaries that are stack allocated
///   or in the global constant pool.
//<editor-fold defaultstate="collapsed" desc="clang::ento::CompoundLiteralRegion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 809,
 FQN="clang::ento::CompoundLiteralRegion", NM="_ZN5clang4ento21CompoundLiteralRegionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento21CompoundLiteralRegionE")
//</editor-fold>
public class CompoundLiteralRegion extends /*public*/ TypedValueRegion implements Destructors.ClassWithDestructor {
/*private:*/
  /*friend  class MemRegionManager*/
  private /*const*/ CompoundLiteralExpr /*P*/ CL;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CompoundLiteralRegion::CompoundLiteralRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 814,
   FQN="clang::ento::CompoundLiteralRegion::CompoundLiteralRegion", NM="_ZN5clang4ento21CompoundLiteralRegionC1EPKNS_19CompoundLiteralExprEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento21CompoundLiteralRegionC1EPKNS_19CompoundLiteralExprEPKNS0_9MemRegionE")
  //</editor-fold>
  /*friend*/public/*private*/ CompoundLiteralRegion(/*const*/ CompoundLiteralExpr /*P*/ cl, /*const*/ MemRegion /*P*/ sReg) {
    // : TypedValueRegion(sReg, CompoundLiteralRegionKind), CL(cl) 
    //START JInit
    super(sReg, Kind.CompoundLiteralRegionKind);
    this.CL = cl;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CompoundLiteralRegion::ProfileRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 291,
   FQN="clang::ento::CompoundLiteralRegion::ProfileRegion", NM="_ZN5clang4ento21CompoundLiteralRegion13ProfileRegionERN4llvm16FoldingSetNodeIDEPKNS_19CompoundLiteralExprEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento21CompoundLiteralRegion13ProfileRegionERN4llvm16FoldingSetNodeIDEPKNS_19CompoundLiteralExprEPKNS0_9MemRegionE")
  //</editor-fold>
  /*friend*/public/*private*/ static void ProfileRegion(final FoldingSetNodeID /*&*/ ID, 
               /*const*/ CompoundLiteralExpr /*P*/ CL, 
               /*const*/ MemRegion /*P*/ superRegion) {
    ID.AddInteger_uint(((/*static_cast*//*uint*/int)(Kind.CompoundLiteralRegionKind.getValue())));
    ID.AddPointer(CL);
    ID.AddPointer(superRegion);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CompoundLiteralRegion::getValueType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 821,
   FQN="clang::ento::CompoundLiteralRegion::getValueType", NM="_ZNK5clang4ento21CompoundLiteralRegion12getValueTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento21CompoundLiteralRegion12getValueTypeEv")
  //</editor-fold>
  @Override public QualType getValueType() /*const*//* override*/ {
    return CL.getType();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CompoundLiteralRegion::isBoundable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 825,
   FQN="clang::ento::CompoundLiteralRegion::isBoundable", NM="_ZNK5clang4ento21CompoundLiteralRegion11isBoundableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento21CompoundLiteralRegion11isBoundableEv")
  //</editor-fold>
  @Override public boolean isBoundable() /*const*//* override*/ {
    return !CL.isFileScope();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CompoundLiteralRegion::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 287,
   FQN="clang::ento::CompoundLiteralRegion::Profile", NM="_ZNK5clang4ento21CompoundLiteralRegion7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento21CompoundLiteralRegion7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*//* override*/ {
    CompoundLiteralRegion.ProfileRegion(ID, CL, superRegion);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CompoundLiteralRegion::dumpToStream">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 475,
   FQN="clang::ento::CompoundLiteralRegion::dumpToStream", NM="_ZNK5clang4ento21CompoundLiteralRegion12dumpToStreamERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento21CompoundLiteralRegion12dumpToStreamERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void dumpToStream(final raw_ostream /*&*/ os) /*const*//* override*/ {
    // FIXME: More elaborate pretty-printing.
    os.$out(/*KEEP_STR*/"{ ").$out((reinterpret_cast(/*static_cast*//*const*/Object/*void P*/ .class, (CL)))).$out(/*KEEP_STR*/" }");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CompoundLiteralRegion::getLiteralExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 831,
   FQN="clang::ento::CompoundLiteralRegion::getLiteralExpr", NM="_ZNK5clang4ento21CompoundLiteralRegion14getLiteralExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento21CompoundLiteralRegion14getLiteralExprEv")
  //</editor-fold>
  public /*const*/ CompoundLiteralExpr /*P*/ getLiteralExpr() /*const*/ {
    return CL;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CompoundLiteralRegion::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 833,
   FQN="clang::ento::CompoundLiteralRegion::classof", NM="_ZN5clang4ento21CompoundLiteralRegion7classofEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento21CompoundLiteralRegion7classofEPKNS0_9MemRegionE")
  //</editor-fold>
  public static boolean classof(/*const*/ MemRegion /*P*/ R) {
    return R.getKind() == Kind.CompoundLiteralRegionKind;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::CompoundLiteralRegion::~CompoundLiteralRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 809,
   FQN="clang::ento::CompoundLiteralRegion::~CompoundLiteralRegion", NM="_ZN5clang4ento21CompoundLiteralRegionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento21CompoundLiteralRegionD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "CL=" + CL // NOI18N
              + super.toString(); // NOI18N
  }
}
