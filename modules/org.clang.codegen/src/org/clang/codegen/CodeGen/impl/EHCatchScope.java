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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.ir.*;


/// A scope which attempts to handle some, possibly all, types of
/// exceptions.
///
/// Objective C \@finally blocks are represented using a cleanup scope
/// after the catch scope.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCatchScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 148,
 FQN="clang::CodeGen::EHCatchScope", NM="_ZN5clang7CodeGen12EHCatchScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHCatchScopeE")
//</editor-fold>
public class EHCatchScope extends /*public*/ EHScope {
// In effect, we have a flexible array member
  //   Handler Handlers[0];
  // But that's only standard in C99, not C++, so we have to do
  // annoying pointer arithmetic instead.
  /*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCatchScope::Handler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 155,
   FQN="clang::CodeGen::EHCatchScope::Handler", NM="_ZN5clang7CodeGen12EHCatchScope7HandlerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHCatchScope7HandlerE")
  //</editor-fold>
  public static class/*struct*/ Handler {
    /// A type info value, or null (C++ null, not an LLVM null pointer)
    /// for a catch-all.
    public CatchTypeInfo Type;
    
    /// The catch handler for this type.
    public BasicBlock /*P*/ Block;
    
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCatchScope::Handler::isCatchAll">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 163,
     FQN="clang::CodeGen::EHCatchScope::Handler::isCatchAll", NM="_ZNK5clang7CodeGen12EHCatchScope7Handler10isCatchAllEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen12EHCatchScope7Handler10isCatchAllEv")
    //</editor-fold>
    public boolean isCatchAll() /*const*/ {
      return Type.RTTI == null;
    }


    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCatchScope::Handler::Handler">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 155,
     FQN="clang::CodeGen::EHCatchScope::Handler::Handler", NM="_ZN5clang7CodeGen12EHCatchScope7HandlerC1ERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN5clang7CodeGen12EHCatchScope7HandlerC1ERKS2_")
    //</editor-fold>
    public /*inline*/ Handler(final /*const*/ Handler /*&*/ $Prm0) {
      // : Type(.Type), Block(.Block) 
      //START JInit
      this.Type = new CatchTypeInfo($Prm0.Type);
      this.Block = $Prm0.Block;
      //END JInit
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    public Handler() {}

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "Type=" + Type // NOI18N
                + ", Block=" + Block; // NOI18N
    }
  };
/*private:*/
  /*friend  class EHScopeStack*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCatchScope::getHandlers">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 169,
   FQN="clang::CodeGen::EHCatchScope::getHandlers", NM="_ZN5clang7CodeGen12EHCatchScope11getHandlersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHCatchScope11getHandlersEv")
  //</editor-fold>
  private type$ptr<Handler /*P*/> getHandlers() {
    return $tryClone($this_plus_1);//reinterpret_cast(Handler /*P*/ .class, this + 1);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCatchScope::getHandlers">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 173,
   FQN="clang::CodeGen::EHCatchScope::getHandlers", NM="_ZNK5clang7CodeGen12EHCatchScope11getHandlersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen12EHCatchScope11getHandlersEv")
  //</editor-fold>
  private type$ptr</*const*/ Handler /*P*/> getHandlers$Const() /*const*/ {
    return $tryClone($this_plus_1);//reinterpret_cast(/*const*/ Handler /*P*/ .class, this + 1);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCatchScope::getSizeForNumHandlers">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 178,
   FQN="clang::CodeGen::EHCatchScope::getSizeForNumHandlers", NM="_ZN5clang7CodeGen12EHCatchScope21getSizeForNumHandlersEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHCatchScope21getSizeForNumHandlersEj")
  //</editor-fold>
  public static /*size_t*/int getSizeForNumHandlers(/*uint*/int N) {
    return 1/*JAVA: $sizeof_EHCatchScope()*/+N*1/*JAVA: $sizeof_Handler()*/;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCatchScope::EHCatchScope">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 182,
   FQN="clang::CodeGen::EHCatchScope::EHCatchScope", NM="_ZN5clang7CodeGen12EHCatchScopeC1EjNS0_12EHScopeStack15stable_iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHCatchScopeC1EjNS0_12EHScopeStack15stable_iteratorE")
  //</editor-fold>
  public EHCatchScope(/*uint*/int numHandlers, 
      EHScopeStack.stable_iterator enclosingEHScope) {
    // : EHScope(Catch, enclosingEHScope) 
    //START JInit
    super(Kind.Catch, new EHScopeStack.stable_iterator(enclosingEHScope));
    //END JInit
    Unnamed_field3.CatchBits.NumHandlers = numHandlers;
    assert (Unnamed_field3.CatchBits.NumHandlers == numHandlers) : "NumHandlers overflow?";
    $this_plus_1 = create_type$ptr(new Handler[numHandlers]);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCatchScope::getNumHandlers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 189,
   FQN="clang::CodeGen::EHCatchScope::getNumHandlers", NM="_ZNK5clang7CodeGen12EHCatchScope14getNumHandlersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen12EHCatchScope14getNumHandlersEv")
  //</editor-fold>
  public /*uint*/int getNumHandlers() /*const*/ {
    return Unnamed_field3.CatchBits.NumHandlers;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCatchScope::setCatchAllHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 193,
   FQN="clang::CodeGen::EHCatchScope::setCatchAllHandler", NM="_ZN5clang7CodeGen12EHCatchScope18setCatchAllHandlerEjPN4llvm10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHCatchScope18setCatchAllHandlerEjPN4llvm10BasicBlockE")
  //</editor-fold>
  public void setCatchAllHandler(/*uint*/int I, BasicBlock /*P*/ Block) {
    setHandler(I, ((CatchTypeInfo)(new CatchTypeInfo(null, 0))), Block);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCatchScope::setHandler">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 197,
   FQN="clang::CodeGen::EHCatchScope::setHandler", NM="_ZN5clang7CodeGen12EHCatchScope10setHandlerEjPN4llvm8ConstantEPNS2_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHCatchScope10setHandlerEjPN4llvm8ConstantEPNS2_10BasicBlockE")
  //</editor-fold>
  public void setHandler(/*uint*/int I, Constant /*P*/ Type, BasicBlock /*P*/ Block) {
    assert ($less_uint(I, getNumHandlers()));
    getHandlers().$at(I).Type.$assignMove(((CatchTypeInfo)(new CatchTypeInfo(Type, 0))));
    getHandlers().$at(I).Block = Block;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCatchScope::setHandler">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 203,
   FQN="clang::CodeGen::EHCatchScope::setHandler", NM="_ZN5clang7CodeGen12EHCatchScope10setHandlerEjNS0_13CatchTypeInfoEPN4llvm10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHCatchScope10setHandlerEjNS0_13CatchTypeInfoEPN4llvm10BasicBlockE")
  //</editor-fold>
  public void setHandler(/*uint*/int I, CatchTypeInfo Type, BasicBlock /*P*/ Block) {
    assert ($less_uint(I, getNumHandlers()));
    getHandlers().$at(I).Type.$assign(Type);
    getHandlers().$at(I).Block = Block;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCatchScope::getHandler">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 209,
   FQN="clang::CodeGen::EHCatchScope::getHandler", NM="_ZNK5clang7CodeGen12EHCatchScope10getHandlerEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen12EHCatchScope10getHandlerEj")
  //</editor-fold>
  public /*const*/ Handler /*&*/ getHandler(/*uint*/int I) /*const*/ {
    assert ($less_uint(I, getNumHandlers()));
    return getHandlers$Const().$at(I);
  }

  
  // Clear all handler blocks.
  // FIXME: it's better to always call clearHandlerBlocks in DTOR and have a
  // 'takeHandler' or some such function which removes ownership from the
  // EHCatchScope object if the handlers should live longer than EHCatchScope.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCatchScope::clearHandlerBlocks">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 218,
   FQN="clang::CodeGen::EHCatchScope::clearHandlerBlocks", NM="_ZN5clang7CodeGen12EHCatchScope18clearHandlerBlocksEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHCatchScope18clearHandlerBlocksEv")
  //</editor-fold>
  public void clearHandlerBlocks() {
    for (/*uint*/int I = 0, N = getNumHandlers(); I != N; ++I)  {
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)getHandler(I).Block);
    }
  }

  
  // JAVA: typedef const Handler *iterator
//  public final class iterator extends /*const*/ Handler /*P*/ { };
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCatchScope::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 224,
   FQN="clang::CodeGen::EHCatchScope::begin", NM="_ZNK5clang7CodeGen12EHCatchScope5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen12EHCatchScope5beginEv")
  //</editor-fold>
  public type$ptr</*const*/ Handler /*P*/ > begin() /*const*/ {
    return getHandlers$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCatchScope::end">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 225,
   FQN="clang::CodeGen::EHCatchScope::end", NM="_ZNK5clang7CodeGen12EHCatchScope3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZNK5clang7CodeGen12EHCatchScope3endEv")
  //</editor-fold>
  public type$ptr</*const*/ Handler /*P*/ > end() /*const*/ {
    return getHandlers$Const().$add(getNumHandlers());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::EHCatchScope::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.h", line = 227,
   FQN="clang::CodeGen::EHCatchScope::classof", NM="_ZN5clang7CodeGen12EHCatchScope7classofEPKNS0_7EHScopeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCleanup.cpp -nm=_ZN5clang7CodeGen12EHCatchScope7classofEPKNS0_7EHScopeE")
  //</editor-fold>
  public static boolean classof(/*const*/ EHScope /*P*/ Scope) {
    return Scope.getKind() == Kind.Catch;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private final type$ptr</*const*/ Handler /*P*/ > $this_plus_1;

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
