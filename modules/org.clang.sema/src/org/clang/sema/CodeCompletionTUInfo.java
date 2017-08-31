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
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;

//<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionTUInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 515,
 FQN="clang::CodeCompletionTUInfo", NM="_ZN5clang20CodeCompletionTUInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang20CodeCompletionTUInfoE")
//</editor-fold>
public class CodeCompletionTUInfo implements Destructors.ClassWithDestructor {
  private DenseMap</*const*/ DeclContext /*P*/ , StringRef> ParentNames;
  private IntrusiveRefCntPtr<GlobalCodeCompletionAllocator> AllocatorRef;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionTUInfo::CodeCompletionTUInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 520,
   FQN="clang::CodeCompletionTUInfo::CodeCompletionTUInfo", NM="_ZN5clang20CodeCompletionTUInfoC1EN4llvm18IntrusiveRefCntPtrINS_29GlobalCodeCompletionAllocatorEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang20CodeCompletionTUInfoC1EN4llvm18IntrusiveRefCntPtrINS_29GlobalCodeCompletionAllocatorEEE")
  //</editor-fold>
  public /*explicit*/ CodeCompletionTUInfo(IntrusiveRefCntPtr<GlobalCodeCompletionAllocator> Allocator) {
    // : ParentNames(), AllocatorRef(std::move(Allocator)) 
    //START JInit
    this.ParentNames = new DenseMap</*const*/ DeclContext /*P*/ , StringRef>(DenseMapInfo$LikePtr.$Info(), new StringRef());
    this.AllocatorRef = new IntrusiveRefCntPtr<GlobalCodeCompletionAllocator>(JD$Move.INSTANCE, std.move(Allocator));
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionTUInfo::getAllocatorRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 524,
   FQN="clang::CodeCompletionTUInfo::getAllocatorRef", NM="_ZNK5clang20CodeCompletionTUInfo15getAllocatorRefEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZNK5clang20CodeCompletionTUInfo15getAllocatorRefEv")
  //</editor-fold>
  public IntrusiveRefCntPtr<GlobalCodeCompletionAllocator> getAllocatorRef() /*const*/ {
    return new IntrusiveRefCntPtr<GlobalCodeCompletionAllocator>(AllocatorRef);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionTUInfo::getAllocator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 527,
   FQN="clang::CodeCompletionTUInfo::getAllocator", NM="_ZNK5clang20CodeCompletionTUInfo12getAllocatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZNK5clang20CodeCompletionTUInfo12getAllocatorEv")
  //</editor-fold>
  public CodeCompletionAllocator /*&*/ getAllocator() /*const*/ {
    assert ((AllocatorRef).$bool());
    return AllocatorRef.$star();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionTUInfo::getParentName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp", line = 266,
   FQN="clang::CodeCompletionTUInfo::getParentName", NM="_ZN5clang20CodeCompletionTUInfo13getParentNameEPKNS_11DeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang20CodeCompletionTUInfo13getParentNameEPKNS_11DeclContextE")
  //</editor-fold>
  public StringRef getParentName(/*const*/ DeclContext /*P*/ DC) {
    /*const*/ NamedDecl /*P*/ ND = dyn_cast_NamedDecl(DC);
    if (!(ND != null)) {
      return new StringRef();
    }
    
    // Check whether we've already cached the parent name.
    final StringRef /*&*/ CachedParentName = ParentNames.$at_T1$C$R(DC);
    if (!CachedParentName.empty()) {
      return new StringRef(CachedParentName);
    }
    
    // If we already processed this DeclContext and assigned empty to it, the
    // data pointer will be non-null.
    if ($noteq_ptr(CachedParentName.data(), null)) {
      return new StringRef();
    }
    
    // Find the interesting names.
    SmallVector</*const*/ DeclContext /*P*/ > Contexts/*J*/= new SmallVector</*const*/ DeclContext /*P*/ >(2, (/*const*/ DeclContext /*P*/ )null);
    while ((DC != null) && !DC.isFunctionOrMethod()) {
      {
        /*const*/ NamedDecl /*P*/ _ND = dyn_cast_NamedDecl(DC);
        if ((_ND != null)) {
          if ((_ND.getIdentifier() != null)) {
            Contexts.push_back(DC);
          }
        }
      }
      
      DC = DC.getParent$Const();
    }
    {
      raw_svector_ostream OS = null;
      try {
        SmallString/*128*/ S/*J*/= new SmallString/*128*/(128);
        OS/*J*/= new raw_svector_ostream(S);
        boolean First = true;
        for (/*uint*/int I = Contexts.size(); I != 0; --I) {
          if (First) {
            First = false;
          } else {
            OS.$out(/*KEEP_STR*/$COLON_COLON);
          }
          
          /*const*/ DeclContext /*P*/ CurDC = Contexts.$at(I - 1);
          {
            /*const*/ ObjCCategoryImplDecl /*P*/ CatImpl = dyn_cast_ObjCCategoryImplDecl(CurDC);
            if ((CatImpl != null)) {
              CurDC = CatImpl.getCategoryDecl();
            }
          }
          {
            
            /*const*/ ObjCCategoryDecl /*P*/ Cat = dyn_cast_ObjCCategoryDecl(CurDC);
            if ((Cat != null)) {
              /*const*/ ObjCInterfaceDecl /*P*/ Interface = Cat.getClassInterface$Const();
              if (!(Interface != null)) {
                // Assign an empty StringRef but with non-null data to distinguish
                // between empty because we didn't process the DeclContext yet.
                CachedParentName.$assignMove(new StringRef((/*const*/char$ptr/*char P*/ )(Object/*uintptr_t*/)~0/*U*/, 0));
                return new StringRef();
              }
              
              OS.$out(Interface.getName()).$out_char($$LPAREN).$out(Cat.getName()).$out_char($$RPAREN);
            } else {
              OS.$out(cast_NamedDecl(CurDC).getName());
            }
          }
        }
        
        CachedParentName.$assignMove(/*STRINGREF_STR*/AllocatorRef.$arrow().CopyString(new Twine(OS.str())));
      } finally {
        if (OS != null) { OS.$destroy(); }
      }
    }
    
    return new StringRef(CachedParentName);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionTUInfo::~CodeCompletionTUInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 515,
   FQN="clang::CodeCompletionTUInfo::~CodeCompletionTUInfo", NM="_ZN5clang20CodeCompletionTUInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang20CodeCompletionTUInfoD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    AllocatorRef.$destroy();
    ParentNames.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "ParentNames=" + ParentNames // NOI18N
              + ", AllocatorRef=" + "[IntrusiveRefCntPtr$GlobalCodeCompletionAllocator]"; // NOI18N
  }
}
