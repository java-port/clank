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
import org.clank.support.aliases.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.sema.*;
import static org.clang.sema.java.SemaFunctionPointers.*;
import static org.clang.ast.java.AstFunctionPointers.*;


//<editor-fold defaultstate="collapsed" desc="static type SemaCUDAStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCUDA.cpp -nm=Tpl__ZL28EraseUnwantedCUDAMatchesImplRN5clang4SemaEPKNS_12FunctionDeclERN4llvm15SmallVectorImplIT_EESt8functionIFS4_RKS7_EE;_ZL31resolveCalleeCUDATargetConflictN5clang4Sema18CUDAFunctionTargetES1_PS1_; -static-type=SemaCUDAStatics -package=org.clang.sema.impl")
//</editor-fold>
public final class SemaCUDAStatics {

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="EraseUnwantedCUDAMatchesImpl">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCUDA.cpp", line = 149,
 FQN="EraseUnwantedCUDAMatchesImpl", NM="Tpl__ZL28EraseUnwantedCUDAMatchesImplRN5clang4SemaEPKNS_12FunctionDeclERN4llvm15SmallVectorImplIT_EESt8functionIFS4_RKS7_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCUDA.cpp -nm=Tpl__ZL28EraseUnwantedCUDAMatchesImplRN5clang4SemaEPKNS_12FunctionDeclERN4llvm15SmallVectorImplIT_EESt8functionIFS4_RKS7_EE")
//</editor-fold>
public static </*typename*/ T> void EraseUnwantedCUDAMatchesImpl(final Sema /*&*/ S, /*const*/ FunctionDecl /*P*/ Caller, final SmallVectorImpl<T> /*&*/ Matches, 
                            T2FunctionDecl<T> FetchDecl) {
  if (Native.$lesseq(Matches.size(), 1)) {
    return;
  }
  
  // Gets the CUDA function preference for a call from Caller to Match.
  T2CUDAFunctionPreference<T> GetCFP =  /*[&]*/(/*const*/ T /*&*/Match) -> { 
      return S.IdentifyCUDAPreference(Caller, FetchDecl.$call(Match));
    };
  
  // Find the best call preference among the functions in Matches.
  Sema.CUDAFunctionPreference BestCFP = GetCFP.$call(Native.$star(std.max_element(
          Matches.begin(), Matches.end(), 
          /*[&]*/(/*const*/ T /*&*/M1, /*const*/ T /*&*/M2) -> { return Native.$less(GetCFP.$call(M1), GetCFP.$call(M2)); }
          )
        ));
  
  // Erase all functions with lower priority.
  Matches.erase(
      llvm.remove_if(Matches, 
                    /*[&]*/(/*const*/ T /*&*/Match) -> { return Native.$less(GetCFP.$call(Match), BestCFP); }),
      Matches.end());
}


/// When an implicitly-declared special member has to invoke more than one
/// base/field special member, conflicts may occur in the targets of these
/// members. For example, if one base's member __host__ and another's is
/// __device__, it's a conflict.
/// This function figures out if the given targets \param Target1 and
/// \param Target2 conflict, and if they do not it fills in
/// \param ResolvedTarget with a target that resolves for both calls.
/// \return true if there's a conflict, false otherwise.
//<editor-fold defaultstate="collapsed" desc="resolveCalleeCUDATargetConflict">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCUDA.cpp", line = 204,
 FQN="resolveCalleeCUDATargetConflict", NM="_ZL31resolveCalleeCUDATargetConflictN5clang4Sema18CUDAFunctionTargetES1_PS1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCUDA.cpp -nm=_ZL31resolveCalleeCUDATargetConflictN5clang4Sema18CUDAFunctionTargetES1_PS1_")
//</editor-fold>
public static boolean resolveCalleeCUDATargetConflict(Sema.CUDAFunctionTarget Target1, 
                               Sema.CUDAFunctionTarget Target2, 
                               type$ref<Sema.CUDAFunctionTarget>/*P*/ ResolvedTarget) {
  // Only free functions and static member functions may be global.
  assert (Target1 != Sema.CUDAFunctionTarget.CFT_Global);
  assert (Target2 != Sema.CUDAFunctionTarget.CFT_Global);
  if (Target1 == Sema.CUDAFunctionTarget.CFT_HostDevice) {
    ResolvedTarget.$set(Target2);
  } else if (Target2 == Sema.CUDAFunctionTarget.CFT_HostDevice) {
    ResolvedTarget.$set(Target1);
  } else if (Target1 != Target2) {
    return true;
  } else {
    ResolvedTarget.$set(Target1);
  }
  
  return false;
}

} // END OF class SemaCUDAStatics
