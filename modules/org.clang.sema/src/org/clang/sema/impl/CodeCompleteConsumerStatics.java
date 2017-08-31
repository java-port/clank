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
package org.clang.sema.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
;
import org.clang.basic.*;
import org.clang.sema.*;
import org.clang.sema.CodeCompletionString.Chunk;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type CodeCompleteConsumerStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZL14getOrderedNameRKN5clang20CodeCompletionResultERSs;_ZL19getDeclAvailabilityPKN5clang4DeclE;_ZL19getOverloadAsStringRKN5clang20CodeCompletionStringE; -static-type=CodeCompleteConsumerStatics -package=org.clang.sema.impl")
//</editor-fold>
public final class CodeCompleteConsumerStatics {


// This function is used solely to preserve the former presentation of overloads
// by "clang -cc1 -code-completion-at", since CodeCompletionString::getAsString
// needs to be improved for printing the newer and more detailed overload
// chunks.
//<editor-fold defaultstate="collapsed" desc="getOverloadAsString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp", line = 489,
 FQN="getOverloadAsString", NM="_ZL19getOverloadAsStringRKN5clang20CodeCompletionStringE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZL19getOverloadAsStringRKN5clang20CodeCompletionStringE")
//</editor-fold>
public static std.string getOverloadAsString(final /*const*/ CodeCompletionString /*&*/ CCS) {
  raw_string_ostream OS = null;
  try {
    std.string Result/*J*/= new std.string();
    OS/*J*/= new raw_string_ostream(Result);
    
    for (final /*const*/ Chunk /*&*/ C : CCS) {
      switch (C.Kind) {
       case CK_Informative:
       case CK_ResultType:
        OS.$out(/*KEEP_STR*/"[#").$out(C.Unnamed_field1.Text).$out(/*KEEP_STR*/"#]");
        break;
       case CK_CurrentParameter:
        OS.$out(/*KEEP_STR*/"<#").$out(C.Unnamed_field1.Text).$out(/*KEEP_STR*/"#>");
        break;
       default:
        OS.$out(C.Unnamed_field1.Text);
        break;
      }
    }
    return new std.string(OS.str());
  } finally {
    if (OS != null) { OS.$destroy(); }
  }
}


/// \brief Retrieve the effective availability of the given declaration.
//<editor-fold defaultstate="collapsed" desc="getDeclAvailability">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp", line = 526,
 FQN="getDeclAvailability", NM="_ZL19getDeclAvailabilityPKN5clang4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZL19getDeclAvailabilityPKN5clang4DeclE")
//</editor-fold>
public static AvailabilityResult getDeclAvailability(/*const*/ Decl /*P*/ D) {
  AvailabilityResult AR = D.getAvailability();
  if (isa_EnumConstantDecl(D)) {
    AR = std.max(AR, cast_Decl(D.getDeclContext$Const()).getAvailability());
  }
  return AR;
}


/// \brief Retrieve the name that should be used to order a result.
///
/// If the name needs to be constructed as a string, that string will be
/// saved into Saved and the returned StringRef will refer to it.
//<editor-fold defaultstate="collapsed" desc="getOrderedName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp", line = 591,
 FQN="getOrderedName", NM="_ZL14getOrderedNameRKN5clang20CodeCompletionResultERSs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZL14getOrderedNameRKN5clang20CodeCompletionResultERSs")
//</editor-fold>
public static StringRef getOrderedName(final /*const*/ CodeCompletionResult /*&*/ R, 
              final std.string/*&*/ Saved) {
  switch (R.Kind) {
   case RK_Keyword:
    return new StringRef(R.Unnamed_field1.Keyword);
   case RK_Pattern:
    return new StringRef(R.Unnamed_field1.Pattern.getTypedText());
   case RK_Macro:
    return R.Unnamed_field1.Macro.getName();
   case RK_Declaration:
    // Handle declarations below.
    break;
  }
  
  DeclarationName Name = R.Declaration.getDeclName();
  {
    
    // If the name is a simple identifier (by far the common case), or a
    // zero-argument selector, just return a reference to that identifier.
    IdentifierInfo /*P*/ Id = Name.getAsIdentifierInfo();
    if ((Id != null)) {
      return Id.getName();
    }
  }
  if (Name.isObjCZeroArgSelector()) {
    {
      IdentifierInfo /*P*/ Id = Name.getObjCSelector().getIdentifierInfoForSlot(0);
      if ((Id != null)) {
        return Id.getName();
      }
    }
  }
  
  Saved.$assignMove(Name.getAsString());
  return new StringRef(Saved);
}

} // END OF class CodeCompleteConsumerStatics
