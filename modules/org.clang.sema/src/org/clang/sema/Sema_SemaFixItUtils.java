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
package org.clang.sema;

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.java.std.*;
import org.clang.ast.*;
import org.clang.basic.*;
import static org.clang.sema.impl.SemaFixItUtilsStatics.*;


//<editor-fold defaultstate="collapsed" desc="static type Sema_SemaFixItUtils">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this -extends=Sema_SemaExprObjC ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaFixItUtils.cpp -nm=_ZNK5clang4Sema26getFixItZeroLiteralForTypeENS_8QualTypeENS_14SourceLocationE;_ZNK5clang4Sema30getFixItZeroInitializerForTypeENS_8QualTypeENS_14SourceLocationE; -static-type=Sema_SemaFixItUtils -package=org.clang.sema")
//</editor-fold>
public class Sema_SemaFixItUtils extends Sema_SemaExprObjC {
private final /*split clang::Sema*/ Sema $this() { return (Sema)this; }


/// \brief Get a string to suggest for zero-initialization of a type.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::getFixItZeroInitializerForType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaFixItUtils.cpp", line = 200,
 FQN="clang::Sema::getFixItZeroInitializerForType", NM="_ZNK5clang4Sema30getFixItZeroInitializerForTypeENS_8QualTypeENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaFixItUtils.cpp -nm=_ZNK5clang4Sema30getFixItZeroInitializerForTypeENS_8QualTypeENS_14SourceLocationE")
//</editor-fold>
public final std.string getFixItZeroInitializerForType(QualType T, SourceLocation Loc) /*const*/ {
  if (T.$arrow().isScalarType()) {
    std.string s = getScalarZeroExpressionForType(T.$star(), new SourceLocation(Loc), /*Deref*/$this());
    if (!s.empty()) {
      s.$assignMove($add_T$C$P_string$C(/*KEEP_STR*/" = ", s));
    }
    return s;
  }
  
  /*const*/ CXXRecordDecl /*P*/ RD = T.$arrow().getAsCXXRecordDecl();
  if (!(RD != null) || !RD.hasDefinition()) {
    return new std.string();
  }
  if ($this().LangOpts.CPlusPlus11 && !RD.hasUserProvidedDefaultConstructor()) {
    return new std.string(/*KEEP_STR*/"{}");
  }
  if (RD.isAggregate()) {
    return new std.string(/*KEEP_STR*/" = {}");
  }
  return new std.string();
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::getFixItZeroLiteralForType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaFixItUtils.cpp", line = 219,
 FQN="clang::Sema::getFixItZeroLiteralForType", NM="_ZNK5clang4Sema26getFixItZeroLiteralForTypeENS_8QualTypeENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaFixItUtils.cpp -nm=_ZNK5clang4Sema26getFixItZeroLiteralForTypeENS_8QualTypeENS_14SourceLocationE")
//</editor-fold>
public final std.string getFixItZeroLiteralForType(QualType T, SourceLocation Loc) /*const*/ {
  return getScalarZeroExpressionForType(T.$star(), new SourceLocation(Loc), /*Deref*/$this());
}

} // END OF class Sema_SemaFixItUtils
