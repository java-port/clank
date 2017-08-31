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

package org.clang.basic.impl;

import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import static org.clang.basic.impl.DiagnosticIDsStatics.CLASS_REMARK;
import org.clang.basic.java.diagJava;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StaticDiagInfoRec">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", line = 39,
 FQN="(anonymous namespace)::StaticDiagInfoRec", NM="_ZN12_GLOBAL__N_117StaticDiagInfoRecE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZN12_GLOBAL__N_117StaticDiagInfoRecE")
//</editor-fold>
public class/*struct*/ StaticDiagInfoRec implements Native.ComparableLower {
  public final /*uint16_t*/char DiagID;
  public final /*JBYTE unsigned int*/ byte DefaultSeverity /*: 3*/;
  public final /*JBYTE unsigned int*/ byte Class /*: 3*/;
  public final /*JBYTE unsigned int*/ DiagnosticIDs.SFINAEResponse SFINAE /*: 2*/;
  public final /*JBIT unsigned int*/ boolean WarnNoWerror /*: 1*/;
  public final /*JBIT unsigned int*/ boolean WarnShowInSystemHeader /*: 1*/;
  public final /*JBYTE unsigned int*/ byte Category /*: 5*/;
  
  public final /*uint16_t*/char OptionGroupIndex;
  
  // JAVA: MANUAL_SEMANTIC changed fields to int/String pair
  public final /*uint16_t*/int DescriptionLen;
  public final /*const*/String/*char P*/ DescriptionStr;
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public StaticDiagInfoRec(int DiagID, diag.Severity Severety, int Class, DiagnosticIDs.SFINAEResponse SFINAE, boolean WarnNoWerror, boolean WarnShowInSystemHeader, int Category, int OptionGroupIndex, String DescriptionStr) {
    this.DiagID = (char) DiagID;
    this.DefaultSeverity = (byte) Severety.getValue();
    this.Class = (byte) Class;
    this.SFINAE = SFINAE;
    this.WarnNoWerror = WarnNoWerror;
    this.WarnShowInSystemHeader = WarnShowInSystemHeader;
    this.Category = (byte) Category;
    this.OptionGroupIndex = (char) OptionGroupIndex;
    this.DescriptionLen = DescriptionStr.length();
    this.DescriptionStr = DescriptionStr;
  }
    
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StaticDiagInfoRec::getOptionGroupIndex">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", line = 53,
   FQN="(anonymous namespace)::StaticDiagInfoRec::getOptionGroupIndex", NM="_ZNK12_GLOBAL__N_117StaticDiagInfoRec19getOptionGroupIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZNK12_GLOBAL__N_117StaticDiagInfoRec19getOptionGroupIndexEv")
  //</editor-fold>
  public /*uint*/int getOptionGroupIndex() /*const*/ {
    return $ushort2uint(OptionGroupIndex);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StaticDiagInfoRec::getDescription">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", line = 57,
   FQN="(anonymous namespace)::StaticDiagInfoRec::getDescription", NM="_ZNK12_GLOBAL__N_117StaticDiagInfoRec14getDescriptionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZNK12_GLOBAL__N_117StaticDiagInfoRec14getDescriptionEv")
  //</editor-fold>
  public StringRef getDescription() /*const*/ {
    return new StringRef(DescriptionStr, DescriptionLen);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StaticDiagInfoRec::getFlavor">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", line = 61,
   FQN="(anonymous namespace)::StaticDiagInfoRec::getFlavor", NM="_ZNK12_GLOBAL__N_117StaticDiagInfoRec9getFlavorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZNK12_GLOBAL__N_117StaticDiagInfoRec9getFlavorEv")
  //</editor-fold>
  public diag.Flavor getFlavor() /*const*/ {
    return Class == CLASS_REMARK ? diag.Flavor.Remark : diag.Flavor.WarningOrError;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StaticDiagInfoRec::operator<">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", line = 66,
   FQN="(anonymous namespace)::StaticDiagInfoRec::operator<", NM="_ZNK12_GLOBAL__N_117StaticDiagInfoRecltERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZNK12_GLOBAL__N_117StaticDiagInfoRecltERKS0_")
  //</editor-fold>
  public boolean $less(/*const*/ StaticDiagInfoRec /*&*/ RHS) /*const*/ {
    return $less_ushort(DiagID, RHS.DiagID);
  }
  @Override public boolean $less(/*const*/ Object /*&*/ RHS) /*const*/ {
    return $less((StaticDiagInfoRec)RHS);
  }

  
  public String toString() {
    return "" + "DiagID=" + diagJava.$name(DiagID) + "[" + DiagID + "]" // NOI18N
              + ", DefaultSeverity=" + diag.Severity.valueOf(DefaultSeverity) // NOI18N
              + ", Class=" + diagJava.$diagClass(Class) // NOI18N
              + ", SFINAE=" + SFINAE // NOI18N
              + ", WarnNoWerror=" + WarnNoWerror // NOI18N
              + ", WarnShowInSystemHeader=" + WarnShowInSystemHeader // NOI18N
              + ", Category=" + diagJava.$categoryName(Category) // NOI18N
              + ", OptionGroupIndex=" + $ushort2uint(OptionGroupIndex) // NOI18N
              + ", DescriptionLen=" + DescriptionLen // NOI18N
              + ", DescriptionStr=" + DescriptionStr; // NOI18N
  }
}
