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

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.java.std.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.basic.*;

import static org.clang.basic.diag.DIAG_UPPER_LIMIT;


//<editor-fold defaultstate="collapsed" desc="static type DiagStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZN5clang4diag14CustomDiagInfoE; -static-type=DiagStatics -package=org.clang.basic.impl")
//</editor-fold>
public final class DiagStatics {

//<editor-fold defaultstate="collapsed" desc="clang::diag::CustomDiagInfo">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", line = 254,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", old_line = 258,
 FQN="clang::diag::CustomDiagInfo", NM="_ZN5clang4diag14CustomDiagInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZN5clang4diag14CustomDiagInfoE")
//</editor-fold>
public static class CustomDiagInfo implements Destructors.ClassWithDestructor {
  /*typedef std::pair<DiagnosticIDs::Level, std::string> DiagDesc*/
//  public final class DiagDesc extends std.pair<DiagnosticIDs.Level, std.string>{ };
  private std.vector<std.pair<DiagnosticIDs.Level, std.string> > DiagInfo;
  private std.mapTypeUInt<std.pair<DiagnosticIDs.Level, std.string>/*, uint*/> DiagIDs;
/*public:*/
  
  /// getDescription - Return the description of the specified custom
  /// diagnostic.
  //<editor-fold defaultstate="collapsed" desc="clang::diag::CustomDiagInfo::getDescription">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", line = 262,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", old_line = 266,
   FQN="clang::diag::CustomDiagInfo::getDescription", NM="_ZNK5clang4diag14CustomDiagInfo14getDescriptionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZNK5clang4diag14CustomDiagInfo14getDescriptionEj")
  //</editor-fold>
  public StringRef getDescription(/*uint*/int DiagID) /*const*/ {
    assert ($less_uint(DiagID - DIAG_UPPER_LIMIT, DiagInfo.size())) : "Invalid diagnostic ID";
    return new StringRef(DiagInfo.$at(DiagID - DIAG_UPPER_LIMIT).second);
  }

  
  /// getLevel - Return the level of the specified custom diagnostic.
  //<editor-fold defaultstate="collapsed" desc="clang::diag::CustomDiagInfo::getLevel">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", line = 269,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", old_line = 273,
   FQN="clang::diag::CustomDiagInfo::getLevel", NM="_ZNK5clang4diag14CustomDiagInfo8getLevelEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZNK5clang4diag14CustomDiagInfo8getLevelEj")
  //</editor-fold>
  public DiagnosticIDs.Level getLevel(/*uint*/int DiagID) /*const*/ {
    assert ($less_uint(DiagID - DIAG_UPPER_LIMIT, DiagInfo.size())) : "Invalid diagnostic ID";
    return DiagInfo.$at(DiagID - DIAG_UPPER_LIMIT).first;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::diag::CustomDiagInfo::getOrCreateDiagID">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", line = 275,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", old_line = 279,
   FQN="clang::diag::CustomDiagInfo::getOrCreateDiagID", NM="_ZN5clang4diag14CustomDiagInfo17getOrCreateDiagIDENS_13DiagnosticIDs5LevelEN4llvm9StringRefERS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZN5clang4diag14CustomDiagInfo17getOrCreateDiagIDENS_13DiagnosticIDs5LevelEN4llvm9StringRefERS2_")
  //</editor-fold>
  public /*uint*/int getOrCreateDiagID(DiagnosticIDs.Level L, StringRef Message, 
                   DiagnosticIDs /*&*/ Diags) {
    // JAVA: removed JavaCleaner and D.$destroy
    std.pair<DiagnosticIDs.Level, std.string> D/*J*/= new std.pair<DiagnosticIDs.Level, std.string>(L, Message.$string());
    // Check to see if it already exists.
    std.mapTypeUInt.iterator<std.pair<DiagnosticIDs.Level, std.string>/*, uint*/> I = DiagIDs.lower_bound(D);
    if (I.$noteq(DiagIDs.end()) && $eq_pair$C(I.$arrow().first, D)) {
      return I.$arrow().second;
    }

    // If not, assign a new ID.
    /*uint*/int ID = DiagInfo.size() + DIAG_UPPER_LIMIT;
    DiagIDs.insert(std.make_pair_T_uint(D, ID));
    DiagInfo.push_back(D);
    return ID;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::diag::CustomDiagInfo::~CustomDiagInfo">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", line = 254,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", old_line = 258,
   FQN="clang::diag::CustomDiagInfo::~CustomDiagInfo", NM="_ZN5clang4diag14CustomDiagInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZN5clang4diag14CustomDiagInfoD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    DiagIDs.$destroy();
    DiagInfo.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="clang::diag::CustomDiagInfo::CustomDiagInfo">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", line = 254,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp", old_line = 258,
   FQN="clang::diag::CustomDiagInfo::CustomDiagInfo", NM="_ZN5clang4diag14CustomDiagInfoC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticIDs.cpp -nm=_ZN5clang4diag14CustomDiagInfoC1Ev")
  //</editor-fold>
  public /*inline*/ CustomDiagInfo() {
    /* : DiagInfo(), DiagIDs()*/ 
    //START JInit
    this.DiagInfo = new std.vector<std.pair<DiagnosticIDs.Level, std.string> >(make_pair(DiagnosticIDs.Level.valueOf(0), (std.string) null));
    this.DiagIDs = new std.mapTypeUInt<std.pair<DiagnosticIDs.Level, std.string>/*, uint*/>(DiagnosticIDsLevel_StdString_Pair_JavaComparator.COMPARATOR, 0);
    //END JInit
  }

  
  public String toString() {
    return "" + "DiagInfo=" + DiagInfo // NOI18N
              + ", DiagIDs=" + DiagIDs; // NOI18N
  }
}
} // END OF class DiagStatics
