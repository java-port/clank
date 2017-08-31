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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;


/// StringRegion - Region associated with a StringLiteral.
//<editor-fold defaultstate="collapsed" desc="clang::ento::StringRegion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 737,
 FQN="clang::ento::StringRegion", NM="_ZN5clang4ento12StringRegionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento12StringRegionE")
//</editor-fold>
public class StringRegion extends /*public*/ TypedValueRegion implements Destructors.ClassWithDestructor {
  /*friend  class MemRegionManager*/
  private /*const*/ StringLiteral /*P*/ Str;
/*protected:*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StringRegion::StringRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 742,
   FQN="clang::ento::StringRegion::StringRegion", NM="_ZN5clang4ento12StringRegionC1EPKNS_13StringLiteralEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento12StringRegionC1EPKNS_13StringLiteralEPKNS0_9MemRegionE")
  //</editor-fold>
  protected StringRegion(/*const*/ StringLiteral /*P*/ str, /*const*/ MemRegion /*P*/ sreg) {
    // : TypedValueRegion(sreg, StringRegionKind), Str(str) 
    //START JInit
    super(sreg, Kind.StringRegionKind);
    this.Str = str;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StringRegion::ProfileRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 258,
   FQN="clang::ento::StringRegion::ProfileRegion", NM="_ZN5clang4ento12StringRegion13ProfileRegionERN4llvm16FoldingSetNodeIDEPKNS_13StringLiteralEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento12StringRegion13ProfileRegionERN4llvm16FoldingSetNodeIDEPKNS_13StringLiteralEPKNS0_9MemRegionE")
  //</editor-fold>
  protected static void ProfileRegion(final FoldingSetNodeID /*&*/ ID, 
               /*const*/ StringLiteral /*P*/ Str, 
               /*const*/ MemRegion /*P*/ superRegion) {
    ID.AddInteger_uint(((/*static_cast*//*uint*/int)(Kind.StringRegionKind.getValue())));
    ID.AddPointer(Str);
    ID.AddPointer(superRegion);
  }

/*public:*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StringRegion::getStringLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 751,
   FQN="clang::ento::StringRegion::getStringLiteral", NM="_ZNK5clang4ento12StringRegion16getStringLiteralEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento12StringRegion16getStringLiteralEv")
  //</editor-fold>
  public /*const*/ StringLiteral /*P*/ getStringLiteral() /*const*/ {
    return Str;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StringRegion::getValueType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 753,
   FQN="clang::ento::StringRegion::getValueType", NM="_ZNK5clang4ento12StringRegion12getValueTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento12StringRegion12getValueTypeEv")
  //</editor-fold>
  @Override public QualType getValueType() /*const*//* override*/ {
    return Str.getType();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StringRegion::getExtent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 220,
   FQN="clang::ento::StringRegion::getExtent", NM="_ZNK5clang4ento12StringRegion9getExtentERNS0_11SValBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento12StringRegion9getExtentERNS0_11SValBuilderE")
  //</editor-fold>
  @Override public DefinedOrUnknownSVal getExtent(final SValBuilder /*&*/ svalBuilder) /*const*//* override*/ {
    return new DefinedOrUnknownSVal(JD$Move.INSTANCE, svalBuilder.makeIntVal($uint2ulong(getStringLiteral().getByteLength() + 1), 
            svalBuilder.getArrayIndexType()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StringRegion::isBoundable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 759,
   FQN="clang::ento::StringRegion::isBoundable", NM="_ZNK5clang4ento12StringRegion11isBoundableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento12StringRegion11isBoundableEv")
  //</editor-fold>
  @Override public boolean isBoundable() /*const*//* override*/ {
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StringRegion::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 761,
   FQN="clang::ento::StringRegion::Profile", NM="_ZNK5clang4ento12StringRegion7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento12StringRegion7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*//* override*/ {
    ProfileRegion(ID, Str, superRegion);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StringRegion::dumpToStream">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 506,
   FQN="clang::ento::StringRegion::dumpToStream", NM="_ZNK5clang4ento12StringRegion12dumpToStreamERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento12StringRegion12dumpToStreamERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void dumpToStream(final raw_ostream /*&*/ os) /*const*//* override*/ {
    assert (Str != null) : "Expecting non-null StringLiteral";
    Str.printPretty(os, (PrinterHelper /*P*/ )null, new PrintingPolicy(getContext().getLangOpts()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StringRegion::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 767,
   FQN="clang::ento::StringRegion::classof", NM="_ZN5clang4ento12StringRegion7classofEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento12StringRegion7classofEPKNS0_9MemRegionE")
  //</editor-fold>
  public static boolean classof(/*const*/ MemRegion /*P*/ R) {
    return R.getKind() == Kind.StringRegionKind;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::StringRegion::~StringRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 737,
   FQN="clang::ento::StringRegion::~StringRegion", NM="_ZN5clang4ento12StringRegionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento12StringRegionD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "Str=" + Str // NOI18N
              + super.toString(); // NOI18N
  }
}
