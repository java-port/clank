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

package org.clang.basic;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.clang.basic.*;


/// \brief Represents an unpacked "presumed" location which can be presented
/// to the user.
///
/// A 'presumed' location can be modified by \#line and GNU line marker
/// directives and is always the expansion point of a normal location.
///
/// You can get a PresumedLoc from a SourceLocation with SourceManager.
//<editor-fold defaultstate="collapsed" desc="clang::PresumedLoc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 356,
 FQN = "clang::PresumedLoc", NM = "_ZN5clang11PresumedLocE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp -nm=_ZN5clang11PresumedLocE")
//</editor-fold>
public class PresumedLoc {
  private /*const*/char$ptr/*char P*/ Filename;
  private /*uint*/int Line;
  private /*uint*/int Col;
  private /*SourceLocation*/int IncludeLoc;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::PresumedLoc::PresumedLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 361,
   FQN = "clang::PresumedLoc::PresumedLoc", NM = "_ZN5clang11PresumedLocC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp -nm=_ZN5clang11PresumedLocC1Ev")
  //</editor-fold>
  public PresumedLoc() {
    /* : Filename(null), IncludeLoc()*/ 
    //START JInit
    this.Filename = null;
    this.IncludeLoc = SourceLocation.getInvalid();
    //END JInit
    trackInstance();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PresumedLoc::PresumedLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 362,
   FQN = "clang::PresumedLoc::PresumedLoc", NM = "_ZN5clang11PresumedLocC1EPKcjjNS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp -nm=_ZN5clang11PresumedLocC1EPKcjjNS_14SourceLocationE")
  //</editor-fold>
  public PresumedLoc(/*const*/char$ptr/*char P*/ FN, /*uint*/int Ln, /*uint*/int Co, SourceLocation IL) {
    /* : Filename(FN), Line(Ln), Col(Co), IncludeLoc(IL)*/ 
    //START JInit
    this.Filename = FN;
    this.Line = Ln;
    this.Col = Co;
    this.IncludeLoc = IL.getRawEncoding();
    //END JInit
    trackInstance();
  }
  public PresumedLoc(/*const*/char$ptr/*char P*/ FN, /*uint*/int Ln, /*uint*/int Co, /*SourceLocation*/int IL) {
    /* : Filename(FN), Line(Ln), Col(Co), IncludeLoc(IL)*/ 
    //START JInit
    this.Filename = FN;
    this.Line = Ln;
    this.Col = Co;
    this.IncludeLoc = IL;
    //END JInit
    trackInstance();
  }

  
  /// \brief Return true if this object is invalid or uninitialized.
  ///
  /// This occurs when created with invalid source locations or when walking
  /// off the top of a \#include stack.
  //<editor-fold defaultstate="collapsed" desc="clang::PresumedLoc::isInvalid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 370,
   FQN = "clang::PresumedLoc::isInvalid", NM = "_ZNK5clang11PresumedLoc9isInvalidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp -nm=_ZNK5clang11PresumedLoc9isInvalidEv")
  //</editor-fold>
  public boolean isInvalid() /*const*/ {
    return Filename == null;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PresumedLoc::isValid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 371,
   FQN = "clang::PresumedLoc::isValid", NM = "_ZNK5clang11PresumedLoc7isValidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp -nm=_ZNK5clang11PresumedLoc7isValidEv")
  //</editor-fold>
  public boolean isValid() /*const*/ {
    return Filename != null;
  }

  
  /// \brief Return the presumed filename of this location.
  ///
  /// This can be affected by \#line etc.
  //<editor-fold defaultstate="collapsed" desc="clang::PresumedLoc::getFilename">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 376,
   FQN = "clang::PresumedLoc::getFilename", NM = "_ZNK5clang11PresumedLoc11getFilenameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp -nm=_ZNK5clang11PresumedLoc11getFilenameEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getFilename() /*const*/ {
    return Filename;
  }

  
  /// \brief Return the presumed line number of this location.
  ///
  /// This can be affected by \#line etc.
  //<editor-fold defaultstate="collapsed" desc="clang::PresumedLoc::getLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 381,
   FQN = "clang::PresumedLoc::getLine", NM = "_ZNK5clang11PresumedLoc7getLineEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp -nm=_ZNK5clang11PresumedLoc7getLineEv")
  //</editor-fold>
  public /*uint*/int getLine() /*const*/ {
    assert (isValid());
    return Line;
  }

  
  /// \brief Return the presumed column number of this location.
  ///
  /// This cannot be affected by \#line, but is packaged here for convenience.
  //<editor-fold defaultstate="collapsed" desc="clang::PresumedLoc::getColumn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 386,
   FQN = "clang::PresumedLoc::getColumn", NM = "_ZNK5clang11PresumedLoc9getColumnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp -nm=_ZNK5clang11PresumedLoc9getColumnEv")
  //</editor-fold>
  public /*uint*/int getColumn() /*const*/ {
    assert (isValid());
    return Col;
  }

  
  /// \brief Return the presumed include location of this location.
  ///
  /// This can be affected by GNU linemarker directives.
  //<editor-fold defaultstate="collapsed" desc="clang::PresumedLoc::getIncludeLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 391,
   FQN = "clang::PresumedLoc::getIncludeLoc", NM = "_ZNK5clang11PresumedLoc13getIncludeLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp -nm=_ZNK5clang11PresumedLoc13getIncludeLocEv")
  //</editor-fold>
  public SourceLocation getIncludeLoc() /*const*/ {
    assert (isValid());
    return new SourceLocation(IncludeLoc);
  }
  public /*SourceLocation*/int $getIncludeLoc() /*const*/ {
    assert (isValid());
    return IncludeLoc;
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::PresumedLoc::PresumedLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 356,
   FQN="clang::PresumedLoc::PresumedLoc", NM="_ZN5clang11PresumedLocC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp -nm=_ZN5clang11PresumedLocC1EOS0_")
  //</editor-fold>
  public /*inline*/ PresumedLoc(JD$Move _dparam, PresumedLoc /*&&*/$Prm0) {
    /* : Filename(static_cast<PresumedLoc &&>().Filename), Line(static_cast<PresumedLoc &&>().Line), Col(static_cast<PresumedLoc &&>().Col), IncludeLoc(static_cast<PresumedLoc &&>().IncludeLoc)*/ 
    //START JInit
    this.Filename = $Prm0.Filename;
    this.Line = $Prm0.Line;
    this.Col = $Prm0.Col;
    this.IncludeLoc = $Prm0.IncludeLoc;
    //END JInit
    trackInstance();
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::PresumedLoc::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 356,
   FQN = "clang::PresumedLoc::operator=", NM = "_ZN5clang11PresumedLocaSEOS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp -nm=_ZN5clang11PresumedLocaSEOS0_")
  //</editor-fold>
  public /*inline*/ PresumedLoc /*&*/ $assignMove(PresumedLoc /*&&*/$Prm0) {
    this.Filename = $Prm0.Filename;
    this.Line = $Prm0.Line;
    this.Col = $Prm0.Col;
    this.IncludeLoc = $Prm0.IncludeLoc;
    return /*Deref*/this;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::PresumedLoc::PresumedLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 356,
   FQN = "clang::PresumedLoc::PresumedLoc", NM = "_ZN5clang11PresumedLocC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang11PresumedLocC1ERKS0_")
  //</editor-fold>
  public /*inline*/ PresumedLoc(/*const*/ PresumedLoc /*&*/ $Prm0) {
    /* : Filename(.Filename), Line(.Line), Col(.Col), IncludeLoc(.IncludeLoc)*/ 
    //START JInit
    this.Filename = $Prm0.Filename;
    this.Line = $Prm0.Line;
    this.Col = $Prm0.Col;
    this.IncludeLoc = $Prm0.IncludeLoc;
    //END JInit
    trackInstance();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PresumedLoc::operator=">
  @Converted(kind = Converted.Kind.AUTO, 
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 356,
   FQN = "clang::PresumedLoc::operator=", NM = "_ZN5clang11PresumedLocaSERKS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PPMacroExpansion.cpp -nm=_ZN5clang11PresumedLocaSERKS0_")
  //</editor-fold>
  public /*inline*/ PresumedLoc /*&*/ $assign(/*const*/PresumedLoc /*&*/ $Prm0)/* throw()*/ {
    this.Filename = $Prm0.Filename;
    this.Line = $Prm0.Line;
    this.Col = $Prm0.Col;
    this.IncludeLoc = $Prm0.IncludeLoc;
    return /*Deref*/this;
  }  
  
  @Override
  public String toString() {
    return "PresumedLoc{" // NOI18N
            + "Filename=" + $toString(Filename) // NOI18N
            + "\n, Line=" + Line // NOI18N
            + ", Col=" + Col // NOI18N
            + ", IncludeLoc=" + SourceLocation.getFromRawEncoding(IncludeLoc) + '}'; // NOI18N
  }
  
    //////////////////////////////////////////////////////////////////////////////
  // Performance Statistics
  private static long instances = 0;
  private static void trackInstance() {
    if (NativeTrace.STATISTICS) instances++;
  }
  
  public static void clearStatistics() {
    instances = 0;
  }

  public static long PrintStats(raw_ostream out) {
    out.$out(String.format("%22s created:\t", PresumedLoc.class.getSimpleName())).$out(NativeTrace.formatNumber(instances)).$out(".\n");
    NativeTrace.dumpStatisticValue(PresumedLoc.class.getSimpleName(), instances);
    return instances;
  }
}
