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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.impl.*;
import org.llvm.ir.FunctionType;
import org.llvm.ir.Type;
import static org.llvm.ir.java.IrRTTI.cast_Constant;
import static org.llvm.ir.java.IrRTTI.cast_Function;

/// Class that lazily initialises the runtime function.  Avoids inserting the
/// types and the function declaration into a module if they're not used, and
/// avoids constructing the type more than once if it's used more than once.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LazyRuntimeFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 45,
 FQN="(anonymous namespace)::LazyRuntimeFunction", NM="_ZN12_GLOBAL__N_119LazyRuntimeFunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_119LazyRuntimeFunctionE")
//</editor-fold>
public class LazyRuntimeFunction {
  private CodeGenModule /*P*/ CGM;
  private FunctionType /*P*/ FTy;
  private /*const*/char$ptr/*char P*/ FunctionName;
  private Constant /*P*/ Function;
/*public:*/
  /// Constructor leaves this class uninitialized, because it is intended to
  /// be used as a field in another class and not all of the types that are
  /// used as arguments will necessarily be available at construction time.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LazyRuntimeFunction::LazyRuntimeFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 55,
   FQN="(anonymous namespace)::LazyRuntimeFunction::LazyRuntimeFunction", NM="_ZN12_GLOBAL__N_119LazyRuntimeFunctionC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_119LazyRuntimeFunctionC1Ev")
  //</editor-fold>
  public LazyRuntimeFunction() {
    // : CGM(null), FunctionName(null), Function(null) 
    //START JInit
    this.CGM = null;
    this.FunctionName = null;
    this.Function = null;
    //END JInit
  }

  
  /// Initialises the lazy function with the name, return type, and the types
  /// of the arguments.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LazyRuntimeFunction::init">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 60,
   FQN="(anonymous namespace)::LazyRuntimeFunction::init", NM="_ZN12_GLOBAL__N_119LazyRuntimeFunction4initEPN5clang7CodeGen13CodeGenModuleEPKcPN4llvm4TypeEz",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_119LazyRuntimeFunction4initEPN5clang7CodeGen13CodeGenModuleEPKcPN4llvm4TypeEz")
  //</editor-fold>
  public void init(CodeGenModule /*P*/ Mod, /*const*/char$ptr/*char P*/ name, Type /*P*/ RetTy, Type ... $VarArg)/* __attribute__((sentinel(0, 0)))*/ {
    std.vector<Type /*P*/ > ArgTys = null;
    try {
      CGM = Mod;
      FunctionName = $tryClone(name);
      Function = null;
      ArgTys/*J*/= new std.vector<Type /*P*/ >((Type /*P*/ )null);
      char$ptr/*char P*/ Args = create_char$ptr();
      //__builtin_va_start(Args, RetTy);
      {
        //Type /*P*/ ArgTy;
        //while (((/*P*/ ArgTy = __builtin_va_arg(Args, Type /*P*/ .class)) != null)) {
        for(Type /*P*/ ArgTy : $VarArg) {
          ArgTys.push_back_T$C$R(ArgTy);
        }
      }
      //__builtin_va_end(Args);
      FTy = FunctionType.get(RetTy, new ArrayRef<Type /*P*/ >(ArgTys, true), false);
    } finally {
      if (ArgTys != null) { ArgTys.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LazyRuntimeFunction::getType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 74,
   FQN="(anonymous namespace)::LazyRuntimeFunction::getType", NM="_ZN12_GLOBAL__N_119LazyRuntimeFunction7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_119LazyRuntimeFunction7getTypeEv")
  //</editor-fold>
  public FunctionType /*P*/ getType() {
    return FTy;
  }

  
  /// Overloaded cast operator, allows the class to be implicitly cast to an
  /// LLVM constant.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LazyRuntimeFunction::operator Constant * ">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 78,
   FQN="(anonymous namespace)::LazyRuntimeFunction::operator Constant * ", NM="_ZN12_GLOBAL__N_119LazyRuntimeFunctioncvPN4llvm8ConstantEEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_119LazyRuntimeFunctioncvPN4llvm8ConstantEEv")
  //</editor-fold>
  public Constant /*P*/ $Constant$P() {
    if (!(Function != null)) {
      if (!Native.$bool(FunctionName)) {
        return null;
      }
      Function
         = cast_Constant(CGM.CreateRuntimeFunction(FTy, new StringRef(FunctionName)));
    }
    return Function;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LazyRuntimeFunction::operator Function * ">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 87,
   FQN="(anonymous namespace)::LazyRuntimeFunction::operator Function * ", NM="_ZN12_GLOBAL__N_119LazyRuntimeFunctioncvPN4llvm8FunctionEEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_119LazyRuntimeFunctioncvPN4llvm8FunctionEEv")
  //</editor-fold>
  public Function /*P*/ $Function$P() {
    return cast_Function((Constant /*P*/ )/*Deref*/this.$Constant$P());
  }

  
  @Override public String toString() {
    return "" + "CGM=" + CGM // NOI18N
              + ", FTy=" + FTy // NOI18N
              + ", FunctionName=" + FunctionName // NOI18N
              + ", Function=" + Function; // NOI18N
  }
}
