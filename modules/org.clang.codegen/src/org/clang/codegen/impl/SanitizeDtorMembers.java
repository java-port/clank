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

package org.clang.codegen.impl;

import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.impl.*;
import static org.clang.codegen.impl.CGClassStatics.FieldHasTrivialDestructorBody;
import static org.clang.codegen.impl.CGClassStatics.EmitSanitizerDtorCallback;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SanitizeDtorMembers">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 1693,
 FQN="(anonymous namespace)::SanitizeDtorMembers", NM="_ZN12_GLOBAL__N_119SanitizeDtorMembersE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN12_GLOBAL__N_119SanitizeDtorMembersE")
//</editor-fold>
public final class SanitizeDtorMembers extends /*public*/ EHScopeStack.Cleanup {
  private /*const*/ CXXDestructorDecl /*P*/ Dtor;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SanitizeDtorMembers::SanitizeDtorMembers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 1697,
   FQN="(anonymous namespace)::SanitizeDtorMembers::SanitizeDtorMembers", NM="_ZN12_GLOBAL__N_119SanitizeDtorMembersC1EPKN5clang17CXXDestructorDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN12_GLOBAL__N_119SanitizeDtorMembersC1EPKN5clang17CXXDestructorDeclE")
  //</editor-fold>
  public SanitizeDtorMembers(/*const*/ CXXDestructorDecl /*P*/ Dtor) {
    // : EHScopeStack::Cleanup(), Dtor(Dtor) 
    //START JInit
    super();
    this.Dtor = Dtor;
    //END JInit
  }

  
  // Generate function call for handling object poisoning.
  // Disables tail call elimination, to prevent the current stack frame
  // from disappearing from the stack trace.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SanitizeDtorMembers::Emit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 1702,
   FQN="(anonymous namespace)::SanitizeDtorMembers::Emit", NM="_ZN12_GLOBAL__N_119SanitizeDtorMembers4EmitERN5clang7CodeGen15CodeGenFunctionENS2_12EHScopeStack7Cleanup5FlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN12_GLOBAL__N_119SanitizeDtorMembers4EmitERN5clang7CodeGen15CodeGenFunctionENS2_12EHScopeStack7Cleanup5FlagsE")
  //</editor-fold>
  @Override public void Emit(final CodeGenFunction /*&*/ CGF, EHScopeStack.Cleanup.Flags flags)/* override*/ {
    final /*const*/ ASTRecordLayout /*&*/ Layout = CGF.getContext().getASTRecordLayout(Dtor.getParent$Const());
    
    // Nothing to poison.
    if (Layout.getFieldCount() == 0) {
      return;
    }
    
    // Prevent the current stack frame from disappearing from the stack trace.
    CGF.CurFn.addFnAttr(new StringRef(/*KEEP_STR*/"disable-tail-calls"), new StringRef(/*KEEP_STR*/$true));
    
    // Construct pointer to region to begin poisoning, and calculate poison
    // size, so that only members declared in this class are poisoned.
    final ASTContext /*&*/ Context = CGF.getContext();
    /*uint*/int fieldIndex = 0;
    int startIndex = -1;
    // RecordDecl::field_iterator Field;
    for (/*const*/ FieldDecl /*P*/ Field : Dtor.getParent$Const().fields()) {
      // Poison field if it is trivial
      if (FieldHasTrivialDestructorBody(Context, Field)) {
        // Start sanitizing at this field
        if (startIndex < 0) {
          startIndex = fieldIndex;
        }
        
        // Currently on the last field, and it must be poisoned with the
        // current block.
        if (fieldIndex == Layout.getFieldCount() - 1) {
          PoisonMembers(CGF, startIndex, Layout.getFieldCount());
        }
      } else if (startIndex >= 0) {
        // No longer within a block of memory to poison, so poison the block
        PoisonMembers(CGF, startIndex, fieldIndex);
        // Re-set the start index
        startIndex = -1;
      }
      fieldIndex += 1;
    }
  }

/*private:*/
  /// \param layoutStartOffset index of the ASTRecordLayout field to
  ///     start poisoning (inclusive)
  /// \param layoutEndOffset index of the ASTRecordLayout field to
  ///     end poisoning (exclusive)
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SanitizeDtorMembers::PoisonMembers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 1746,
   FQN="(anonymous namespace)::SanitizeDtorMembers::PoisonMembers", NM="_ZN12_GLOBAL__N_119SanitizeDtorMembers13PoisonMembersERN5clang7CodeGen15CodeGenFunctionEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN12_GLOBAL__N_119SanitizeDtorMembers13PoisonMembersERN5clang7CodeGen15CodeGenFunctionEjj")
  //</editor-fold>
  private void PoisonMembers(final CodeGenFunction /*&*/ CGF, /*uint*/int layoutStartOffset, 
               /*uint*/int layoutEndOffset) {
    final ASTContext /*&*/ Context = CGF.getContext();
    final /*const*/ ASTRecordLayout /*&*/ Layout = Context.getASTRecordLayout(Dtor.getParent$Const());
    
    ConstantInt /*P*/ OffsetSizePtr = ConstantInt.get(CGF.Unnamed_field8.SizeTy, 
        Context.toCharUnitsFromBits(Layout.getFieldOffset(layoutStartOffset)).
            getQuantity());
    
    Value /*P*/ OffsetPtr = CGF.Builder.CreateGEP(CGF.Builder.CreateBitCast(CGF.LoadCXXThis(), CGF.Unnamed_field9.Int8PtrTy), 
        OffsetSizePtr);
    
    long/*int64_t*/ PoisonSize;
    if ($greatereq_uint(layoutEndOffset, Layout.getFieldCount())) {
      PoisonSize = Layout.getNonVirtualSize().getQuantity()
         - Context.toCharUnitsFromBits(Layout.getFieldOffset(layoutStartOffset)).
          getQuantity();
    } else {
      PoisonSize = Context.toCharUnitsFromBits(Layout.getFieldOffset(layoutEndOffset)
             - Layout.getFieldOffset(layoutStartOffset)).
          getQuantity();
    }
    if (PoisonSize == 0) {
      return;
    }
    
    EmitSanitizerDtorCallback(CGF, OffsetPtr, PoisonSize);
  }

  
  @Override public String toString() {
    return "" + "Dtor=" + "[CXXDestructorDecl]" // NOI18N
              + super.toString(); // NOI18N
  }
}
