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

import org.clank.support.*;
import static org.llvm.support.llvm.*;
import org.clang.ast.*;
import org.clang.sema.*;

// Callback to only accept typo corrections that are either
// Objective-C protocols or valid Objective-C type arguments.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCTypeArgOrProtocolValidatorCCC">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 1255,
 FQN="(anonymous namespace)::ObjCTypeArgOrProtocolValidatorCCC", NM="_ZN12_GLOBAL__N_133ObjCTypeArgOrProtocolValidatorCCCE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN12_GLOBAL__N_133ObjCTypeArgOrProtocolValidatorCCCE")
//</editor-fold>
public class ObjCTypeArgOrProtocolValidatorCCC extends /*public*/ CorrectionCandidateCallback implements Destructors.ClassWithDestructor {
  private final ASTContext /*&*/ Context;
  private Sema.LookupNameKind LookupKind;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCTypeArgOrProtocolValidatorCCC::ObjCTypeArgOrProtocolValidatorCCC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 1259,
   FQN="(anonymous namespace)::ObjCTypeArgOrProtocolValidatorCCC::ObjCTypeArgOrProtocolValidatorCCC", NM="_ZN12_GLOBAL__N_133ObjCTypeArgOrProtocolValidatorCCCC1ERN5clang10ASTContextENS1_4Sema14LookupNameKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN12_GLOBAL__N_133ObjCTypeArgOrProtocolValidatorCCCC1ERN5clang10ASTContextENS1_4Sema14LookupNameKindE")
  //</editor-fold>
  public ObjCTypeArgOrProtocolValidatorCCC(final ASTContext /*&*/ context, 
      Sema.LookupNameKind lookupKind) {
    // : CorrectionCandidateCallback(), Context(context), LookupKind(lookupKind) 
    //START JInit
    super();
    this./*&*/Context=/*&*/context;
    this.LookupKind = lookupKind;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCTypeArgOrProtocolValidatorCCC::ValidateCandidate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 1263,
   FQN="(anonymous namespace)::ObjCTypeArgOrProtocolValidatorCCC::ValidateCandidate", NM="_ZN12_GLOBAL__N_133ObjCTypeArgOrProtocolValidatorCCC17ValidateCandidateERKN5clang14TypoCorrectionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN12_GLOBAL__N_133ObjCTypeArgOrProtocolValidatorCCC17ValidateCandidateERKN5clang14TypoCorrectionE")
  //</editor-fold>
  @Override public boolean ValidateCandidate(final /*const*/ TypoCorrection /*&*/ candidate)/* override*/ {
    // If we're allowed to find protocols and we have a protocol, accept it.
    if (LookupKind != Sema.LookupNameKind.LookupOrdinaryName) {
      if ((candidate.<ObjCProtocolDecl>getCorrectionDeclAs(ObjCProtocolDecl.class) != null)) {
        return true;
      }
    }
    
    // If we're allowed to find type names and we have one, accept it.
    if (LookupKind != Sema.LookupNameKind.LookupObjCProtocolName) {
      {
        // If we have a type declaration, we might accept this result.
        TypeDecl /*P*/ typeDecl = candidate.<TypeDecl>getCorrectionDeclAs(TypeDecl.class);
        if ((typeDecl != null)) {
          // If we found a tag declaration outside of C++, skip it. This
          // can happy because we look for any name when there is no
          // bias to protocol or type names.
          if (isa(RecordDecl.class, typeDecl) && !Context.getLangOpts().CPlusPlus) {
            return false;
          }
          
          // Make sure the type is something we would accept as a type
          // argument.
          QualType type = Context.getTypeDeclType(typeDecl);
          if (type.$arrow().isObjCObjectPointerType()
             || type.$arrow().isBlockPointerType()
             || type.$arrow().isDependentType()
             || type.$arrow().isObjCObjectType()) {
            return true;
          }
          
          return false;
        }
      }
      
      // If we have an Objective-C class type, accept it; there will
      // be another fix to add the '*'.
      if ((candidate.<ObjCInterfaceDecl>getCorrectionDeclAs(ObjCInterfaceDecl.class) != null)) {
        return true;
      }
      
      return false;
    }
    
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCTypeArgOrProtocolValidatorCCC::~ObjCTypeArgOrProtocolValidatorCCC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 1255,
   FQN="(anonymous namespace)::ObjCTypeArgOrProtocolValidatorCCC::~ObjCTypeArgOrProtocolValidatorCCC", NM="_ZN12_GLOBAL__N_133ObjCTypeArgOrProtocolValidatorCCCD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN12_GLOBAL__N_133ObjCTypeArgOrProtocolValidatorCCCD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "Context=" + Context // NOI18N
              + ", LookupKind=" + LookupKind // NOI18N
              + super.toString(); // NOI18N
  }
}
