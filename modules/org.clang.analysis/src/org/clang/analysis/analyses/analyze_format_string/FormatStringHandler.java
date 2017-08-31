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

package org.clang.analysis.analyses.analyze_format_string;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clang.analysis.analyses.analyze_format_string.*;
import org.clang.analysis.analyses.analyze_scanf.*;
import org.clang.analysis.analyses.analyze_printf.*;

//<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::FormatStringHandler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 605,
 FQN="clang::analyze_format_string::FormatStringHandler", NM="_ZN5clang21analyze_format_string19FormatStringHandlerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string19FormatStringHandlerE")
//</editor-fold>
public class FormatStringHandler implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::FormatStringHandler::FormatStringHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 607,
   FQN="clang::analyze_format_string::FormatStringHandler::FormatStringHandler", NM="_ZN5clang21analyze_format_string19FormatStringHandlerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string19FormatStringHandlerC1Ev")
  //</editor-fold>
  public FormatStringHandler() {
  }

  
  // Key function to FormatStringHandler.
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::FormatStringHandler::~FormatStringHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp", line = 30,
   FQN="clang::analyze_format_string::FormatStringHandler::~FormatStringHandler", NM="_ZN5clang21analyze_format_string19FormatStringHandlerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string19FormatStringHandlerD0Ev")
  //</editor-fold>
  public void $destroy() {
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::FormatStringHandler::HandleNullChar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 610,
   FQN="clang::analyze_format_string::FormatStringHandler::HandleNullChar", NM="_ZN5clang21analyze_format_string19FormatStringHandler14HandleNullCharEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string19FormatStringHandler14HandleNullCharEPKc")
  //</editor-fold>
  public /*virtual*/ void HandleNullChar(/*const*/char$ptr/*char P*/ nullCharacter) {
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::FormatStringHandler::HandlePosition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 612,
   FQN="clang::analyze_format_string::FormatStringHandler::HandlePosition", NM="_ZN5clang21analyze_format_string19FormatStringHandler14HandlePositionEPKcj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string19FormatStringHandler14HandlePositionEPKcj")
  //</editor-fold>
  public /*virtual*/ void HandlePosition(/*const*/char$ptr/*char P*/ startPos, /*uint*/int posLen) {
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::FormatStringHandler::HandleInvalidPosition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 614,
   FQN="clang::analyze_format_string::FormatStringHandler::HandleInvalidPosition", NM="_ZN5clang21analyze_format_string19FormatStringHandler21HandleInvalidPositionEPKcjNS0_15PositionContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string19FormatStringHandler21HandleInvalidPositionEPKcjNS0_15PositionContextE")
  //</editor-fold>
  public /*virtual*/ void HandleInvalidPosition(/*const*/char$ptr/*char P*/ startPos, /*uint*/int posLen, 
                       PositionContext p) {
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::FormatStringHandler::HandleZeroPosition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 617,
   FQN="clang::analyze_format_string::FormatStringHandler::HandleZeroPosition", NM="_ZN5clang21analyze_format_string19FormatStringHandler18HandleZeroPositionEPKcj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string19FormatStringHandler18HandleZeroPositionEPKcj")
  //</editor-fold>
  public /*virtual*/ void HandleZeroPosition(/*const*/char$ptr/*char P*/ startPos, /*uint*/int posLen) {
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::FormatStringHandler::HandleIncompleteSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 619,
   FQN="clang::analyze_format_string::FormatStringHandler::HandleIncompleteSpecifier", NM="_ZN5clang21analyze_format_string19FormatStringHandler25HandleIncompleteSpecifierEPKcj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string19FormatStringHandler25HandleIncompleteSpecifierEPKcj")
  //</editor-fold>
  public /*virtual*/ void HandleIncompleteSpecifier(/*const*/char$ptr/*char P*/ startSpecifier, 
                           /*uint*/int specifierLen) {
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::FormatStringHandler::HandleEmptyObjCModifierFlag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 622,
   FQN="clang::analyze_format_string::FormatStringHandler::HandleEmptyObjCModifierFlag", NM="_ZN5clang21analyze_format_string19FormatStringHandler27HandleEmptyObjCModifierFlagEPKcj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string19FormatStringHandler27HandleEmptyObjCModifierFlagEPKcj")
  //</editor-fold>
  public /*virtual*/ void HandleEmptyObjCModifierFlag(/*const*/char$ptr/*char P*/ startFlags, 
                             /*uint*/int flagsLen) {
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::FormatStringHandler::HandleInvalidObjCModifierFlag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 625,
   FQN="clang::analyze_format_string::FormatStringHandler::HandleInvalidObjCModifierFlag", NM="_ZN5clang21analyze_format_string19FormatStringHandler29HandleInvalidObjCModifierFlagEPKcj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string19FormatStringHandler29HandleInvalidObjCModifierFlagEPKcj")
  //</editor-fold>
  public /*virtual*/ void HandleInvalidObjCModifierFlag(/*const*/char$ptr/*char P*/ startFlag, 
                               /*uint*/int flagLen) {
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::FormatStringHandler::HandleObjCFlagsWithNonObjCConversion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 628,
   FQN="clang::analyze_format_string::FormatStringHandler::HandleObjCFlagsWithNonObjCConversion", NM="_ZN5clang21analyze_format_string19FormatStringHandler36HandleObjCFlagsWithNonObjCConversionEPKcS3_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string19FormatStringHandler36HandleObjCFlagsWithNonObjCConversionEPKcS3_S3_")
  //</editor-fold>
  public /*virtual*/ void HandleObjCFlagsWithNonObjCConversion(/*const*/char$ptr/*char P*/ flagsStart, 
                                      /*const*/char$ptr/*char P*/ flagsEnd, 
                                      /*const*/char$ptr/*char P*/ conversionPosition) {
  }

  // Printf-specific handlers.
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::FormatStringHandler::HandleInvalidPrintfConversionSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 633,
   FQN="clang::analyze_format_string::FormatStringHandler::HandleInvalidPrintfConversionSpecifier", NM="_ZN5clang21analyze_format_string19FormatStringHandler38HandleInvalidPrintfConversionSpecifierERKNS_14analyze_printf15PrintfSpecifierEPKcj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string19FormatStringHandler38HandleInvalidPrintfConversionSpecifierERKNS_14analyze_printf15PrintfSpecifierEPKcj")
  //</editor-fold>
  public /*virtual*/ boolean HandleInvalidPrintfConversionSpecifier(final /*const*/ PrintfSpecifier /*&*/ FS, 
                                        /*const*/char$ptr/*char P*/ startSpecifier, 
                                        /*uint*/int specifierLen) {
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::FormatStringHandler::HandlePrintfSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 640,
   FQN="clang::analyze_format_string::FormatStringHandler::HandlePrintfSpecifier", NM="_ZN5clang21analyze_format_string19FormatStringHandler21HandlePrintfSpecifierERKNS_14analyze_printf15PrintfSpecifierEPKcj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string19FormatStringHandler21HandlePrintfSpecifierERKNS_14analyze_printf15PrintfSpecifierEPKcj")
  //</editor-fold>
  public /*virtual*/ boolean HandlePrintfSpecifier(final /*const*/ PrintfSpecifier /*&*/ FS, 
                       /*const*/char$ptr/*char P*/ startSpecifier, 
                       /*uint*/int specifierLen) {
    return true;
  }

  
  // Scanf-specific handlers.
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::FormatStringHandler::HandleInvalidScanfConversionSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 648,
   FQN="clang::analyze_format_string::FormatStringHandler::HandleInvalidScanfConversionSpecifier", NM="_ZN5clang21analyze_format_string19FormatStringHandler37HandleInvalidScanfConversionSpecifierERKNS_13analyze_scanf14ScanfSpecifierEPKcj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string19FormatStringHandler37HandleInvalidScanfConversionSpecifierERKNS_13analyze_scanf14ScanfSpecifierEPKcj")
  //</editor-fold>
  public /*virtual*/ boolean HandleInvalidScanfConversionSpecifier(final /*const*/ ScanfSpecifier /*&*/ FS, 
                                       /*const*/char$ptr/*char P*/ startSpecifier, 
                                       /*uint*/int specifierLen) {
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::FormatStringHandler::HandleScanfSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 655,
   FQN="clang::analyze_format_string::FormatStringHandler::HandleScanfSpecifier", NM="_ZN5clang21analyze_format_string19FormatStringHandler20HandleScanfSpecifierERKNS_13analyze_scanf14ScanfSpecifierEPKcj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string19FormatStringHandler20HandleScanfSpecifierERKNS_13analyze_scanf14ScanfSpecifierEPKcj")
  //</editor-fold>
  public /*virtual*/ boolean HandleScanfSpecifier(final /*const*/ ScanfSpecifier /*&*/ FS, 
                      /*const*/char$ptr/*char P*/ startSpecifier, 
                      /*uint*/int specifierLen) {
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_format_string::FormatStringHandler::HandleIncompleteScanList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 661,
   FQN="clang::analyze_format_string::FormatStringHandler::HandleIncompleteScanList", NM="_ZN5clang21analyze_format_string19FormatStringHandler24HandleIncompleteScanListEPKcS3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/FormatString.cpp -nm=_ZN5clang21analyze_format_string19FormatStringHandler24HandleIncompleteScanListEPKcS3_")
  //</editor-fold>
  public /*virtual*/ void HandleIncompleteScanList(/*const*/char$ptr/*char P*/ start, /*const*/char$ptr/*char P*/ end) {
  }

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
