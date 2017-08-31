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
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;


/// CXXThisRegion - Represents the region for the implicit 'this' parameter
///  in a call to a C++ method.  This region doesn't represent the object
///  referred to by 'this', but rather 'this' itself.
//<editor-fold defaultstate="collapsed" desc="clang::ento::CXXThisRegion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 896,
 FQN="clang::ento::CXXThisRegion", NM="_ZN5clang4ento13CXXThisRegionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento13CXXThisRegionE")
//</editor-fold>
public class CXXThisRegion extends /*public*/ TypedValueRegion implements Destructors.ClassWithDestructor {
  /*friend  class MemRegionManager*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXThisRegion::CXXThisRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 898,
   FQN="clang::ento::CXXThisRegion::CXXThisRegion", NM="_ZN5clang4ento13CXXThisRegionC1EPKNS_11PointerTypeEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento13CXXThisRegionC1EPKNS_11PointerTypeEPKNS0_9MemRegionE")
  //</editor-fold>
  /*friend*/public/*private*/ CXXThisRegion(/*const*/ PointerType /*P*/ thisPointerTy, 
      /*const*/ MemRegion /*P*/ sReg) {
    // : TypedValueRegion(sReg, CXXThisRegionKind), ThisPointerTy(thisPointerTy) 
    //START JInit
    super(sReg, Kind.CXXThisRegionKind);
    this.ThisPointerTy = thisPointerTy;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXThisRegion::ProfileRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 299,
   FQN="clang::ento::CXXThisRegion::ProfileRegion", NM="_ZN5clang4ento13CXXThisRegion13ProfileRegionERN4llvm16FoldingSetNodeIDEPKNS_11PointerTypeEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento13CXXThisRegion13ProfileRegionERN4llvm16FoldingSetNodeIDEPKNS_11PointerTypeEPKNS0_9MemRegionE")
  //</editor-fold>
  /*friend*/public/*private*/ static void ProfileRegion(final FoldingSetNodeID /*&*/ ID, 
               /*const*/ PointerType /*P*/ PT, 
               /*const*/ MemRegion /*P*/ sRegion) {
    ID.AddInteger_uint(((/*static_cast*//*uint*/int)(Kind.CXXThisRegionKind.getValue())));
    ID.AddPointer(PT);
    ID.AddPointer(sRegion);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXThisRegion::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 307,
   FQN="clang::ento::CXXThisRegion::Profile", NM="_ZNK5clang4ento13CXXThisRegion7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento13CXXThisRegion7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public/*private*/ void Profile(final FoldingSetNodeID /*&*/ ID) /*const*//* override*/ {
    CXXThisRegion.ProfileRegion(ID, ThisPointerTy, superRegion);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXThisRegion::getValueType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 909,
   FQN="clang::ento::CXXThisRegion::getValueType", NM="_ZNK5clang4ento13CXXThisRegion12getValueTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento13CXXThisRegion12getValueTypeEv")
  //</editor-fold>
  @Override public QualType getValueType() /*const*//* override*/ {
    return new QualType(ThisPointerTy, 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXThisRegion::dumpToStream">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 489,
   FQN="clang::ento::CXXThisRegion::dumpToStream", NM="_ZNK5clang4ento13CXXThisRegion12dumpToStreamERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento13CXXThisRegion12dumpToStreamERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void dumpToStream(final raw_ostream /*&*/ os) /*const*//* override*/ {
    os.$out(/*KEEP_STR*/$this);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXThisRegion::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 915,
   FQN="clang::ento::CXXThisRegion::classof", NM="_ZN5clang4ento13CXXThisRegion7classofEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento13CXXThisRegion7classofEPKNS0_9MemRegionE")
  //</editor-fold>
  public static boolean classof(/*const*/ MemRegion /*P*/ R) {
    return R.getKind() == Kind.CXXThisRegionKind;
  }

/*private:*/
  private /*const*/ PointerType /*P*/ ThisPointerTy;
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXThisRegion::~CXXThisRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 896,
   FQN="clang::ento::CXXThisRegion::~CXXThisRegion", NM="_ZN5clang4ento13CXXThisRegionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento13CXXThisRegionD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "ThisPointerTy=" + ThisPointerTy // NOI18N
              + super.toString(); // NOI18N
  }
}
