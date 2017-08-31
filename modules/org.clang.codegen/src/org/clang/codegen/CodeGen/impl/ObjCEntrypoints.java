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

package org.clang.codegen.CodeGen.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.ir.*;

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ObjCEntrypoints">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 113,
 FQN="clang::CodeGen::ObjCEntrypoints", NM="_ZN5clang7CodeGen15ObjCEntrypointsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen15ObjCEntrypointsE")
//</editor-fold>
public class/*struct*/ ObjCEntrypoints {
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::ObjCEntrypoints::ObjCEntrypoints">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 114,
   FQN="clang::CodeGen::ObjCEntrypoints::ObjCEntrypoints", NM="_ZN5clang7CodeGen15ObjCEntrypointsC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen15ObjCEntrypointsC1Ev")
  //</editor-fold>
  public ObjCEntrypoints() {
    //memset(this, 0, sizeof(/*Deref*/this));
  }

  
  /// void objc_autoreleasePoolPop(void*);
  public Constant /*P*/ objc_autoreleasePoolPop;
  
  /// void *objc_autoreleasePoolPush(void);
  public Constant /*P*/ objc_autoreleasePoolPush;
  
  /// id objc_autorelease(id);
  public Constant /*P*/ objc_autorelease;
  
  /// id objc_autoreleaseReturnValue(id);
  public Constant /*P*/ objc_autoreleaseReturnValue;
  
  /// void objc_copyWeak(id *dest, id *src);
  public Constant /*P*/ objc_copyWeak;
  
  /// void objc_destroyWeak(id*);
  public Constant /*P*/ objc_destroyWeak;
  
  /// id objc_initWeak(id*, id);
  public Constant /*P*/ objc_initWeak;
  
  /// id objc_loadWeak(id*);
  public Constant /*P*/ objc_loadWeak;
  
  /// id objc_loadWeakRetained(id*);
  public Constant /*P*/ objc_loadWeakRetained;
  
  /// void objc_moveWeak(id *dest, id *src);
  public Constant /*P*/ objc_moveWeak;
  
  /// id objc_retain(id);
  public Constant /*P*/ objc_retain;
  
  /// id objc_retainAutorelease(id);
  public Constant /*P*/ objc_retainAutorelease;
  
  /// id objc_retainAutoreleaseReturnValue(id);
  public Constant /*P*/ objc_retainAutoreleaseReturnValue;
  
  /// id objc_retainAutoreleasedReturnValue(id);
  public Constant /*P*/ objc_retainAutoreleasedReturnValue;
  
  /// id objc_retainBlock(id);
  public Constant /*P*/ objc_retainBlock;
  
  /// void objc_release(id);
  public Constant /*P*/ objc_release;
  
  /// id objc_storeStrong(id*, id);
  public Constant /*P*/ objc_storeStrong;
  
  /// id objc_storeWeak(id*, id);
  public Constant /*P*/ objc_storeWeak;
  
  /// id objc_unsafeClaimAutoreleasedReturnValue(id);
  public Constant /*P*/ objc_unsafeClaimAutoreleasedReturnValue;
  
  /// A void(void) inline asm to use to mark that the return value of
  /// a call will be immediately retain.
  public InlineAsm /*P*/ retainAutoreleasedReturnValueMarker;
  
  /// void clang.arc.use(...);
  public Constant /*P*/ clang_arc_use;
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public type$ref<Constant/*P*/> objc_initWeak_ref = new type$ref<Constant>() {
    @Override
    public Constant $deref() {
      return objc_initWeak;
    }
  
    @Override
    public Constant $set(Constant value) {
      objc_initWeak = value;
      return objc_initWeak;
    }
  };
  
  public type$ref<Constant/*P*/> objc_destroyWeak_ref = new type$ref<Constant>() {
    @Override
    public Constant $deref() {
      return objc_destroyWeak;
    }
  
    @Override
    public Constant $set(Constant value) {
      objc_destroyWeak = value;
      return objc_destroyWeak;
    }
  };
  
  public type$ref<Constant/*P*/> objc_loadWeak_ref = new type$ref<Constant>() {
    @Override
    public Constant $deref() {
      return objc_loadWeak;
    }
  
    @Override
    public Constant $set(Constant value) {
      objc_loadWeak = value;
      return objc_loadWeak;
    }
  };
  
  public type$ref<Constant/*P*/> objc_loadWeakRetained_ref = new type$ref<Constant>() {
    @Override
    public Constant $deref() {
      return objc_loadWeakRetained;
    }
  
    @Override
    public Constant $set(Constant value) {
      objc_loadWeakRetained = value;
      return objc_loadWeakRetained;
    }
  };
  
  public type$ref<Constant/*P*/> objc_storeWeak_ref = new type$ref<Constant>() {
    @Override
    public Constant $deref() {
      return objc_storeWeak;
    }
  
    @Override
    public Constant $set(Constant value) {
      objc_storeWeak = value;
      return objc_storeWeak;
    }
  };
  
  public type$ref<Constant/*P*/> objc_copyWeak_ref = new type$ref<Constant>() {
    @Override
    public Constant $deref() {
      return objc_copyWeak;
    }
  
    @Override
    public Constant $set(Constant value) {
      objc_copyWeak = value;
      return objc_copyWeak;
    }
  };
  
  public type$ref<Constant/*P*/> objc_moveWeak_ref = new type$ref<Constant>() {
    @Override
    public Constant $deref() {
      return objc_moveWeak;
    }
  
    @Override
    public Constant $set(Constant value) {
      objc_moveWeak = value;
      return objc_moveWeak;
    }
  };
  
  public type$ref<Constant/*P*/> objc_retainAutorelease_ref = new type$ref<Constant>() {
    @Override
    public Constant $deref() {
      return objc_retainAutorelease;
    }
  
    @Override
    public Constant $set(Constant value) {
      objc_retainAutorelease = value;
      return objc_retainAutorelease;
    }
  };
  
  public type$ref<Constant/*P*/> objc_storeStrong_ref = new type$ref<Constant>() {
    @Override
    public Constant $deref() {
      return objc_storeStrong;
    }
  
    @Override
    public Constant $set(Constant value) {
      objc_storeStrong = value;
      return objc_storeStrong;
    }
  };
  
  public type$ref<Constant/*P*/> objc_retain_ref = new type$ref<Constant>() {
    @Override
    public Constant $deref() {
      return objc_retain;
    }
  
    @Override
    public Constant $set(Constant value) {
      objc_retain = value;
      return objc_retain;
    }
  };
  
  public type$ref<Constant/*P*/> objc_retainBlock_ref = new type$ref<Constant>() {
    @Override
    public Constant $deref() {
      return objc_retainBlock;
    }
  
    @Override
    public Constant $set(Constant value) {
      objc_retainBlock = value;
      return objc_retainBlock;
    }
  };
  
  public type$ref<Constant/*P*/> objc_release_ref = new type$ref<Constant>() {
    @Override
    public Constant $deref() {
      return objc_release;
    }
  
    @Override
    public Constant $set(Constant value) {
      objc_release = value;
      return objc_release;
    }
  };
  
  public type$ref<Constant/*P*/> objc_autorelease_ref = new type$ref<Constant>() {
    @Override
    public Constant $deref() {
      return objc_autorelease;
    }
  
    @Override
    public Constant $set(Constant value) {
      objc_autorelease = value;
      return objc_autorelease;
    }
  };
  
  public type$ref<Constant/*P*/> objc_autoreleaseReturnValue_ref = new type$ref<Constant>() {
    @Override
    public Constant $deref() {
      return objc_autoreleaseReturnValue;
    }
  
    @Override
    public Constant $set(Constant value) {
      objc_autoreleaseReturnValue = value;
      return objc_autoreleaseReturnValue;
    }
  };
  
  public type$ref<Constant/*P*/> objc_retainAutoreleaseReturnValue_ref = new type$ref<Constant>() {
    @Override
    public Constant $deref() {
      return objc_retainAutoreleaseReturnValue;
    }
  
    @Override
    public Constant $set(Constant value) {
      objc_retainAutoreleaseReturnValue = value;
      return objc_retainAutoreleaseReturnValue;
    }
  };
  
  public type$ref<Constant/*P*/> objc_retainAutoreleasedReturnValue_ref = new type$ref<Constant>() {
    @Override
    public Constant $deref() {
      return objc_retainAutoreleasedReturnValue;
    }
  
    @Override
    public Constant $set(Constant value) {
      objc_retainAutoreleasedReturnValue = value;
      return objc_retainAutoreleasedReturnValue;
    }
  };
  
  public type$ref<Constant/*P*/> objc_unsafeClaimAutoreleasedReturnValue_ref = new type$ref<Constant>() {
    @Override
    public Constant $deref() {
      return objc_unsafeClaimAutoreleasedReturnValue;
    }
  
    @Override
    public Constant $set(Constant value) {
      objc_unsafeClaimAutoreleasedReturnValue = value;
      return objc_unsafeClaimAutoreleasedReturnValue;
    }
  };
  
  public type$ref<Constant/*P*/> clang_arc_use_ref = new type$ref<Constant>() {
    @Override
    public Constant $deref() {
      return clang_arc_use;
    }
  
    @Override
    public Constant $set(Constant value) {
      clang_arc_use = value;
      return clang_arc_use;
    }
  };
  
  public type$ref<Constant/*P*/> objc_autoreleasePoolPop_ref = new type$ref<Constant>() {
    @Override
    public Constant $deref() {
      return objc_autoreleasePoolPop;
    }
  
    @Override
    public Constant $set(Constant value) {
      objc_autoreleasePoolPop = value;
      return objc_autoreleasePoolPop;
    }
  };
  
  public type$ref<Constant/*P*/> objc_autoreleasePoolPush_ref = new type$ref<Constant>() {
    @Override
    public Constant $deref() {
      return objc_autoreleasePoolPush;
    }
  
    @Override
    public Constant $set(Constant value) {
      objc_autoreleasePoolPush = value;
      return objc_autoreleasePoolPush;
    }
  };
  
  public type$ref<InlineAsm /*P*/> retainAutoreleasedReturnValueMarker_ref = new type$ref<InlineAsm /*P*/>(){
    @Override
    public InlineAsm $deref() {
      return retainAutoreleasedReturnValueMarker;
    }
  
    @Override
    public InlineAsm $set(InlineAsm value) {
      retainAutoreleasedReturnValueMarker = value;
      return retainAutoreleasedReturnValueMarker;
    }    
  };


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "objc_autoreleasePoolPop=" + objc_autoreleasePoolPop // NOI18N
              + ", objc_autoreleasePoolPush=" + objc_autoreleasePoolPush // NOI18N
              + ", objc_autorelease=" + objc_autorelease // NOI18N
              + ", objc_autoreleaseReturnValue=" + objc_autoreleaseReturnValue // NOI18N
              + ", objc_copyWeak=" + objc_copyWeak // NOI18N
              + ", objc_destroyWeak=" + objc_destroyWeak // NOI18N
              + ", objc_initWeak=" + objc_initWeak // NOI18N
              + ", objc_loadWeak=" + objc_loadWeak // NOI18N
              + ", objc_loadWeakRetained=" + objc_loadWeakRetained // NOI18N
              + ", objc_moveWeak=" + objc_moveWeak // NOI18N
              + ", objc_retain=" + objc_retain // NOI18N
              + ", objc_retainAutorelease=" + objc_retainAutorelease // NOI18N
              + ", objc_retainAutoreleaseReturnValue=" + objc_retainAutoreleaseReturnValue // NOI18N
              + ", objc_retainAutoreleasedReturnValue=" + objc_retainAutoreleasedReturnValue // NOI18N
              + ", objc_retainBlock=" + objc_retainBlock // NOI18N
              + ", objc_release=" + objc_release // NOI18N
              + ", objc_storeStrong=" + objc_storeStrong // NOI18N
              + ", objc_storeWeak=" + objc_storeWeak // NOI18N
              + ", objc_unsafeClaimAutoreleasedReturnValue=" + objc_unsafeClaimAutoreleasedReturnValue // NOI18N
              + ", retainAutoreleasedReturnValueMarker=" + retainAutoreleasedReturnValueMarker // NOI18N
              + ", clang_arc_use=" + clang_arc_use; // NOI18N
  }
}
