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

package org.clang.analysis.analyses.analyze_scanf;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clang.analysis.analyses.analyze_format_string.*;

//<editor-fold defaultstate="collapsed" desc="clang::analyze_scanf::ScanfConversionSpecifier">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 540,
 FQN="clang::analyze_scanf::ScanfConversionSpecifier", NM="_ZN5clang13analyze_scanf24ScanfConversionSpecifierE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/extra/clang-tidy/cert/StrToNumCheck.cpp -nm=_ZN5clang13analyze_scanf24ScanfConversionSpecifierE")
//</editor-fold>
public class ScanfConversionSpecifier extends /*public*/ ConversionSpecifier {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_scanf::ScanfConversionSpecifier::ScanfConversionSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 543,
   FQN="clang::analyze_scanf::ScanfConversionSpecifier::ScanfConversionSpecifier", NM="_ZN5clang13analyze_scanf24ScanfConversionSpecifierC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/extra/clang-tidy/cert/StrToNumCheck.cpp -nm=_ZN5clang13analyze_scanf24ScanfConversionSpecifierC1Ev")
  //</editor-fold>
  public ScanfConversionSpecifier() {
    // : ConversionSpecifier(false, null, InvalidSpecifier) 
    //START JInit
    super(false, (/*const*/char$ptr/*char P*/ )null, Kind.InvalidSpecifier);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_scanf::ScanfConversionSpecifier::ScanfConversionSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 546,
   FQN="clang::analyze_scanf::ScanfConversionSpecifier::ScanfConversionSpecifier", NM="_ZN5clang13analyze_scanf24ScanfConversionSpecifierC1EPKcNS_21analyze_format_string19ConversionSpecifier4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/extra/clang-tidy/cert/StrToNumCheck.cpp -nm=_ZN5clang13analyze_scanf24ScanfConversionSpecifierC1EPKcNS_21analyze_format_string19ConversionSpecifier4KindE")
  //</editor-fold>
  public ScanfConversionSpecifier(/*const*/char$ptr/*char P*/ pos, ConversionSpecifier.Kind k) {
    // : ConversionSpecifier(false, pos, k) 
    //START JInit
    super(false, pos, k);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::analyze_scanf::ScanfConversionSpecifier::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 549,
   FQN="clang::analyze_scanf::ScanfConversionSpecifier::classof", NM="_ZN5clang13analyze_scanf24ScanfConversionSpecifier7classofEPKNS_21analyze_format_string19ConversionSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/extra/clang-tidy/cert/StrToNumCheck.cpp -nm=_ZN5clang13analyze_scanf24ScanfConversionSpecifier7classofEPKNS_21analyze_format_string19ConversionSpecifierE")
  //</editor-fold>
  public static boolean classof(/*const*/ ConversionSpecifier /*P*/ CS) {
    return !CS.isPrintfKind();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::analyze_scanf::ScanfConversionSpecifier::ScanfConversionSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/FormatString.h", line = 540,
   FQN="clang::analyze_scanf::ScanfConversionSpecifier::ScanfConversionSpecifier", NM="_ZN5clang13analyze_scanf24ScanfConversionSpecifierC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/extra/clang-tidy/cert/StrToNumCheck.cpp -nm=_ZN5clang13analyze_scanf24ScanfConversionSpecifierC1ERKS1_")
  //</editor-fold>
  public /*inline*/ ScanfConversionSpecifier(final /*const*/ ScanfConversionSpecifier /*&*/ $Prm0) {
    // : ConversionSpecifier() 
    //START JInit
    super($Prm0);
    //END JInit
  }

  public ScanfConversionSpecifier(ConversionSpecifier CS) {
    super(CS);
  }
    
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
