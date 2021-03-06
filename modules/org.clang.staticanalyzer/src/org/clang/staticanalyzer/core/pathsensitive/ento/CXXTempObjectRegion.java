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
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;


// C++ temporary object associated with an expression.
//<editor-fold defaultstate="collapsed" desc="clang::ento::CXXTempObjectRegion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 1045,
 FQN="clang::ento::CXXTempObjectRegion", NM="_ZN5clang4ento19CXXTempObjectRegionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento19CXXTempObjectRegionE")
//</editor-fold>
public class CXXTempObjectRegion extends /*public*/ TypedValueRegion implements Destructors.ClassWithDestructor {
  /*friend  class MemRegionManager*/
  
  private /*const*/ Expr /*P*/ Ex;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXTempObjectRegion::CXXTempObjectRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 1050,
   FQN="clang::ento::CXXTempObjectRegion::CXXTempObjectRegion", NM="_ZN5clang4ento19CXXTempObjectRegionC1EPKNS_4ExprEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento19CXXTempObjectRegionC1EPKNS_4ExprEPKNS0_9MemRegionE")
  //</editor-fold>
  /*friend*/public/*private*/ CXXTempObjectRegion(/*const*/ Expr /*P*/ E, /*const*/ MemRegion /*P*/ sReg) {
    // : TypedValueRegion(sReg, CXXTempObjectRegionKind), Ex(E) 
    //START JInit
    super(sReg, Kind.CXXTempObjectRegionKind);
    this.Ex = E;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXTempObjectRegion::ProfileRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 395,
   FQN="clang::ento::CXXTempObjectRegion::ProfileRegion", NM="_ZN5clang4ento19CXXTempObjectRegion13ProfileRegionERN4llvm16FoldingSetNodeIDEPKNS_4ExprEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento19CXXTempObjectRegion13ProfileRegionERN4llvm16FoldingSetNodeIDEPKNS_4ExprEPKNS0_9MemRegionE")
  //</editor-fold>
  /*friend*/public/*private*/ static void ProfileRegion(final FoldingSetNodeID /*&*/ ID, 
               /*const*/ Expr /*P*/ Ex, 
               /*const*/ MemRegion /*P*/ sReg) {
    ID.AddPointer(Ex);
    ID.AddPointer(sReg);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXTempObjectRegion::getExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 1057,
   FQN="clang::ento::CXXTempObjectRegion::getExpr", NM="_ZNK5clang4ento19CXXTempObjectRegion7getExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento19CXXTempObjectRegion7getExprEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getExpr() /*const*/ {
    return Ex;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXTempObjectRegion::getValueType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 1059,
   FQN="clang::ento::CXXTempObjectRegion::getValueType", NM="_ZNK5clang4ento19CXXTempObjectRegion12getValueTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento19CXXTempObjectRegion12getValueTypeEv")
  //</editor-fold>
  @Override public QualType getValueType() /*const*//* override*/ {
    return Ex.getType();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXTempObjectRegion::dumpToStream">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 480,
   FQN="clang::ento::CXXTempObjectRegion::dumpToStream", NM="_ZNK5clang4ento19CXXTempObjectRegion12dumpToStreamERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento19CXXTempObjectRegion12dumpToStreamERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void dumpToStream(final raw_ostream /*&*/ os) /*const*//* override*/ {
    os.$out(/*KEEP_STR*/"temp_object{").$out(getValueType().getAsString()).$out_char($$COMMA).$out(
        (reinterpret_cast(/*static_cast*//*const*/Object/*void P*/ .class, (Ex)))
    ).$out_char($$RCURLY);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXTempObjectRegion::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 402,
   FQN="clang::ento::CXXTempObjectRegion::Profile", NM="_ZNK5clang4ento19CXXTempObjectRegion7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento19CXXTempObjectRegion7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*//* override*/ {
    ProfileRegion(ID, Ex, getSuperRegion());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXTempObjectRegion::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 1067,
   FQN="clang::ento::CXXTempObjectRegion::classof", NM="_ZN5clang4ento19CXXTempObjectRegion7classofEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento19CXXTempObjectRegion7classofEPKNS0_9MemRegionE")
  //</editor-fold>
  public static boolean classof(/*const*/ MemRegion /*P*/ R) {
    return R.getKind() == Kind.CXXTempObjectRegionKind;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXTempObjectRegion::~CXXTempObjectRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 1045,
   FQN="clang::ento::CXXTempObjectRegion::~CXXTempObjectRegion", NM="_ZN5clang4ento19CXXTempObjectRegionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento19CXXTempObjectRegionD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "Ex=" + Ex // NOI18N
              + super.toString(); // NOI18N
  }
}
