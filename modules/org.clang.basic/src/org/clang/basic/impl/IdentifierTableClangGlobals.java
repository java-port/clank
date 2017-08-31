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
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;


//<editor-fold defaultstate="collapsed" desc="static type IdentifierTableClangGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang19getOperatorSpellingENS_22OverloadedOperatorKindE;_ZN5clang22getNullabilitySpellingENS_15NullabilityKindEb; -static-type=IdentifierTableClangGlobals -package=org.clang.basic.impl")
//</editor-fold>
public final class IdentifierTableClangGlobals {


/// \brief Retrieve the spelling of the given overloaded operator, without 
/// the preceding "operator" keyword.
//<editor-fold defaultstate="collapsed" desc="clang::getOperatorSpelling">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", line = 637,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", old_line = 636,
 FQN="clang::getOperatorSpelling", NM="_ZN5clang19getOperatorSpellingENS_22OverloadedOperatorKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang19getOperatorSpellingENS_22OverloadedOperatorKindE")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ getOperatorSpelling(OverloadedOperatorKind Operator) {
  switch (Operator) {
   case OO_None:
   case NUM_OVERLOADED_OPERATORS:
    return null;
   case OO_New:
    return $new;
   case OO_Delete:
    return $delete;
   case OO_Array_New:
    return $new_LSQUARE_RSQUARE;
   case OO_Array_Delete:
    return $delete_LSQUARE_RSQUARE;
   case OO_Plus:
    return $PLUS;
   case OO_Minus:
    return $MINUS;
   case OO_Star:
    return $STAR;
   case OO_Slash:
    return $SLASH;
   case OO_Percent:
    return $PERCENT;
   case OO_Caret:
    return $CARET;
   case OO_Amp:
    return $AMP;
   case OO_Pipe:
    return $PIPE;
   case OO_Tilde:
    return $TILDE;
   case OO_Exclaim:
    return $EXCLAIM;
   case OO_Equal:
    return $EQ;
   case OO_Less:
    return $LT;
   case OO_Greater:
    return $GT;
   case OO_PlusEqual:
    return $PLUS_EQ;
   case OO_MinusEqual:
    return $MINUS_EQ;
   case OO_StarEqual:
    return $STAR_EQ;
   case OO_SlashEqual:
    return $SLASH_EQ;
   case OO_PercentEqual:
    return $PERCENT_EQ;
   case OO_CaretEqual:
    return $CARET_EQ;
   case OO_AmpEqual:
    return $AMP_EQ;
   case OO_PipeEqual:
    return $PIPE_EQ;
   case OO_LessLess:
    return $LT_LT;
   case OO_GreaterGreater:
    return $GT_GT;
   case OO_LessLessEqual:
    return $LT_LT_EQ;
   case OO_GreaterGreaterEqual:
    return $GT_GT_EQ;
   case OO_EqualEqual:
    return $EQ_EQ;
   case OO_ExclaimEqual:
    return $EXCLAIM_EQ;
   case OO_LessEqual:
    return $LT_EQ;
   case OO_GreaterEqual:
    return $GT_EQ;
   case OO_AmpAmp:
    return $AMP_AMP;
   case OO_PipePipe:
    return $PIPE_PIPE;
   case OO_PlusPlus:
    return $PLUS_PLUS;
   case OO_MinusMinus:
    return $MINUS_MINUS;
   case OO_Comma:
    return $COMMA;
   case OO_ArrowStar:
    return $ARROW_STAR;
   case OO_Arrow:
    return $ARROW;
   case OO_Call:
    return $LPAREN_RPAREN;
   case OO_Subscript:
    return $LSQUARE_RSQUARE;
   case OO_Conditional:
    // ?: can *not* be overloaded, but we need the overload
    // resolution machinery for it.
    return $QMARK;
   case OO_Coawait:
    return $co_await;
  }
  throw new llvm_unreachable("Invalid OverloadedOperatorKind!");
}


/// Retrieve the spelling of the given nullability kind.
//<editor-fold defaultstate="collapsed" desc="clang::getNullabilitySpelling">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", line = 651,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", old_line = 650,
 FQN="clang::getNullabilitySpelling", NM="_ZN5clang22getNullabilitySpellingENS_15NullabilityKindEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang22getNullabilitySpellingENS_15NullabilityKindEb")
//</editor-fold>
public static StringRef getNullabilitySpelling(NullabilityKind kind) {
  return getNullabilitySpelling(kind, 
                      false);
}
public static StringRef getNullabilitySpelling(NullabilityKind kind, 
                      boolean isContextSensitive/*= false*/) {
  switch (kind) {
   case NonNull:
    return new StringRef(isContextSensitive ? $nonnull : $_Nonnull);
   case Nullable:
    return new StringRef(isContextSensitive ? $nullable : $_Nullable);
   case Unspecified:
    return new StringRef(isContextSensitive ? $null_unspecified : $_Null_unspecified);
  }
  throw new llvm_unreachable("Unknown nullability kind.");
}

} // END OF class IdentifierTableClangGlobals
