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
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;


/// The region associated with an ObjCStringLiteral.
//<editor-fold defaultstate="collapsed" desc="clang::ento::ObjCStringRegion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 773,
 FQN="clang::ento::ObjCStringRegion", NM="_ZN5clang4ento16ObjCStringRegionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16ObjCStringRegionE")
//</editor-fold>
public class ObjCStringRegion extends /*public*/ TypedValueRegion implements Destructors.ClassWithDestructor {
  /*friend  class MemRegionManager*/
  private /*const*/ ObjCStringLiteral /*P*/ Str;
/*protected:*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ObjCStringRegion::ObjCStringRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 778,
   FQN="clang::ento::ObjCStringRegion::ObjCStringRegion", NM="_ZN5clang4ento16ObjCStringRegionC1EPKNS_17ObjCStringLiteralEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16ObjCStringRegionC1EPKNS_17ObjCStringLiteralEPKNS0_9MemRegionE")
  //</editor-fold>
  protected ObjCStringRegion(/*const*/ ObjCStringLiteral /*P*/ str, /*const*/ MemRegion /*P*/ sreg) {
    // : TypedValueRegion(sreg, ObjCStringRegionKind), Str(str) 
    //START JInit
    super(sreg, Kind.ObjCStringRegionKind);
    this.Str = str;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ObjCStringRegion::ProfileRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 266,
   FQN="clang::ento::ObjCStringRegion::ProfileRegion", NM="_ZN5clang4ento16ObjCStringRegion13ProfileRegionERN4llvm16FoldingSetNodeIDEPKNS_17ObjCStringLiteralEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16ObjCStringRegion13ProfileRegionERN4llvm16FoldingSetNodeIDEPKNS_17ObjCStringLiteralEPKNS0_9MemRegionE")
  //</editor-fold>
  protected static void ProfileRegion(final FoldingSetNodeID /*&*/ ID, 
               /*const*/ ObjCStringLiteral /*P*/ Str, 
               /*const*/ MemRegion /*P*/ superRegion) {
    ID.AddInteger_uint(((/*static_cast*//*uint*/int)(Kind.ObjCStringRegionKind.getValue())));
    ID.AddPointer(Str);
    ID.AddPointer(superRegion);
  }

/*public:*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ObjCStringRegion::getObjCStringLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 787,
   FQN="clang::ento::ObjCStringRegion::getObjCStringLiteral", NM="_ZNK5clang4ento16ObjCStringRegion20getObjCStringLiteralEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento16ObjCStringRegion20getObjCStringLiteralEv")
  //</editor-fold>
  public /*const*/ ObjCStringLiteral /*P*/ getObjCStringLiteral() /*const*/ {
    return Str;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ObjCStringRegion::getValueType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 789,
   FQN="clang::ento::ObjCStringRegion::getValueType", NM="_ZNK5clang4ento16ObjCStringRegion12getValueTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento16ObjCStringRegion12getValueTypeEv")
  //</editor-fold>
  @Override public QualType getValueType() /*const*//* override*/ {
    return Str.getType();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ObjCStringRegion::isBoundable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 793,
   FQN="clang::ento::ObjCStringRegion::isBoundable", NM="_ZNK5clang4ento16ObjCStringRegion11isBoundableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento16ObjCStringRegion11isBoundableEv")
  //</editor-fold>
  @Override public boolean isBoundable() /*const*//* override*/ {
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ObjCStringRegion::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 795,
   FQN="clang::ento::ObjCStringRegion::Profile", NM="_ZNK5clang4ento16ObjCStringRegion7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento16ObjCStringRegion7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*//* override*/ {
    ProfileRegion(ID, Str, superRegion);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ObjCStringRegion::dumpToStream">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 511,
   FQN="clang::ento::ObjCStringRegion::dumpToStream", NM="_ZNK5clang4ento16ObjCStringRegion12dumpToStreamERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento16ObjCStringRegion12dumpToStreamERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void dumpToStream(final raw_ostream /*&*/ os) /*const*//* override*/ {
    assert (Str != null) : "Expecting non-null ObjCStringLiteral";
    Str.printPretty(os, (PrinterHelper /*P*/ )null, new PrintingPolicy(getContext().getLangOpts()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ObjCStringRegion::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 801,
   FQN="clang::ento::ObjCStringRegion::classof", NM="_ZN5clang4ento16ObjCStringRegion7classofEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16ObjCStringRegion7classofEPKNS0_9MemRegionE")
  //</editor-fold>
  public static boolean classof(/*const*/ MemRegion /*P*/ R) {
    return R.getKind() == Kind.ObjCStringRegionKind;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ObjCStringRegion::~ObjCStringRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 773,
   FQN="clang::ento::ObjCStringRegion::~ObjCStringRegion", NM="_ZN5clang4ento16ObjCStringRegionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16ObjCStringRegionD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "Str=" + Str // NOI18N
              + super.toString(); // NOI18N
  }
}
