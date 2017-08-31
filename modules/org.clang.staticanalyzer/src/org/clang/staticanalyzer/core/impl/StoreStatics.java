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
package org.clang.staticanalyzer.core.impl;

import org.clank.support.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type StoreStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZL16getCXXRecordTypePKN5clang4ento9MemRegionE;_ZL26regionMatchesCXXRecordTypeN5clang4ento4SValENS_8QualTypeE; -static-type=StoreStatics -package=org.clang.staticanalyzer.core.impl")
//</editor-fold>
public final class StoreStatics {

//<editor-fold defaultstate="collapsed" desc="regionMatchesCXXRecordType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp", line = 215,
 FQN="regionMatchesCXXRecordType", NM="_ZL26regionMatchesCXXRecordTypeN5clang4ento4SValENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZL26regionMatchesCXXRecordTypeN5clang4ento4SValENS_8QualTypeE")
//</editor-fold>
public static boolean regionMatchesCXXRecordType(SVal V, QualType Ty) {
  /*const*/ MemRegion /*P*/ MR = V.getAsRegion();
  if (!(MR != null)) {
    return true;
  }
  
  /*const*/ TypedValueRegion /*P*/ TVR = dyn_cast_TypedValueRegion(MR);
  if (!(TVR != null)) {
    return true;
  }
  
  /*const*/ CXXRecordDecl /*P*/ RD = TVR.getValueType().$arrow().getAsCXXRecordDecl();
  if (!(RD != null)) {
    return true;
  }
  
  /*const*/ CXXRecordDecl /*P*/ Expected = Ty.$arrow().getPointeeCXXRecordDecl();
  if (!(Expected != null)) {
    Expected = Ty.$arrow().getAsCXXRecordDecl();
  }
  
  return Expected.getCanonicalDecl$Const() == RD.getCanonicalDecl$Const();
}


/// Returns the static type of the given region, if it represents a C++ class
/// object.
///
/// This handles both fully-typed regions, where the dynamic type is known, and
/// symbolic regions, where the dynamic type is merely bounded (and even then,
/// only ostensibly!), but does not take advantage of any dynamic type info.
//<editor-fold defaultstate="collapsed" desc="getCXXRecordType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp", line = 287,
 FQN="getCXXRecordType", NM="_ZL16getCXXRecordTypePKN5clang4ento9MemRegionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZL16getCXXRecordTypePKN5clang4ento9MemRegionE")
//</editor-fold>
public static /*const*/ CXXRecordDecl /*P*/ getCXXRecordType(/*const*/ MemRegion /*P*/ MR) {
  {
    /*const*/ TypedValueRegion /*P*/ TVR = dyn_cast_TypedValueRegion(MR);
    if ((TVR != null)) {
      return TVR.getValueType().$arrow().getAsCXXRecordDecl();
    }
  }
  {
    /*const*/ SymbolicRegion /*P*/ SR = dyn_cast_SymbolicRegion(MR);
    if ((SR != null)) {
      return SR.getSymbol().getType().$arrow().getPointeeCXXRecordDecl();
    }
  }
  return null;
}

} // END OF class StoreStatics
