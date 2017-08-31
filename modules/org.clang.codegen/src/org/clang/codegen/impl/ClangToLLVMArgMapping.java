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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.clang.codegen.impl.CGCallStatics.getExpansionSize;


/// Encapsulates information about the way function arguments from
/// CGFunctionInfo should be passed to actual LLVM IR function.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClangToLLVMArgMapping">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 1284,
 FQN="(anonymous namespace)::ClangToLLVMArgMapping", NM="_ZN12_GLOBAL__N_121ClangToLLVMArgMappingE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN12_GLOBAL__N_121ClangToLLVMArgMappingE")
//</editor-fold>
public class ClangToLLVMArgMapping implements Destructors.ClassWithDestructor {
  private static /*const*//*uint*/int InvalidIndex = ~0/*U*/;
  private /*uint*/int InallocaArgNo;
  private /*uint*/int SRetArgNo;
  private /*uint*/int TotalIRArgs;
  
  /// Arguments of LLVM IR function corresponding to single Clang argument.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClangToLLVMArgMapping::IRArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 1291,
   FQN="(anonymous namespace)::ClangToLLVMArgMapping::IRArgs", NM="_ZN12_GLOBAL__N_121ClangToLLVMArgMapping6IRArgsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN12_GLOBAL__N_121ClangToLLVMArgMapping6IRArgsE")
  //</editor-fold>
  private static class/*struct*/ IRArgs implements NativeCloneable<IRArgs> {
    public /*uint*/int PaddingArgIndex;
    // Argument is expanded to IR arguments at positions
    // [FirstArgIndex, FirstArgIndex + NumberOfArgs).
    public /*uint*/int FirstArgIndex;
    public /*uint*/int NumberOfArgs;
    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClangToLLVMArgMapping::IRArgs::IRArgs">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 1298,
     FQN="(anonymous namespace)::ClangToLLVMArgMapping::IRArgs::IRArgs", NM="_ZN12_GLOBAL__N_121ClangToLLVMArgMapping6IRArgsC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN12_GLOBAL__N_121ClangToLLVMArgMapping6IRArgsC1Ev")
    //</editor-fold>
    public IRArgs() {
      // : PaddingArgIndex(InvalidIndex), FirstArgIndex(InvalidIndex), NumberOfArgs(0) 
      //START JInit
      this.PaddingArgIndex = InvalidIndex;
      this.FirstArgIndex = InvalidIndex;
      this.NumberOfArgs = 0;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClangToLLVMArgMapping::IRArgs::IRArgs">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 1291,
     FQN="(anonymous namespace)::ClangToLLVMArgMapping::IRArgs::IRArgs", NM="_ZN12_GLOBAL__N_121ClangToLLVMArgMapping6IRArgsC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN12_GLOBAL__N_121ClangToLLVMArgMapping6IRArgsC1ERKS1_")
    //</editor-fold>
    public /*inline*/ IRArgs(final /*const*/ IRArgs /*&*/ $Prm0) {
      // : PaddingArgIndex(.PaddingArgIndex), FirstArgIndex(.FirstArgIndex), NumberOfArgs(.NumberOfArgs) 
      //START JInit
      this.PaddingArgIndex = $Prm0.PaddingArgIndex;
      this.FirstArgIndex = $Prm0.FirstArgIndex;
      this.NumberOfArgs = $Prm0.NumberOfArgs;
      //END JInit
    }

    @Override public IRArgs clone() {
      return new IRArgs(this);
    }

    @Override public String toString() {
      return "" + "PaddingArgIndex=" + PaddingArgIndex // NOI18N
                + ", FirstArgIndex=" + FirstArgIndex // NOI18N
                + ", NumberOfArgs=" + NumberOfArgs; // NOI18N
    }
  };
  
  private SmallVector<IRArgs> ArgInfo;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClangToLLVMArgMapping::ClangToLLVMArgMapping">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 1306,
   FQN="(anonymous namespace)::ClangToLLVMArgMapping::ClangToLLVMArgMapping", NM="_ZN12_GLOBAL__N_121ClangToLLVMArgMappingC1ERKN5clang10ASTContextERKNS1_7CodeGen14CGFunctionInfoEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN12_GLOBAL__N_121ClangToLLVMArgMappingC1ERKN5clang10ASTContextERKNS1_7CodeGen14CGFunctionInfoEb")
  //</editor-fold>
  public ClangToLLVMArgMapping(final /*const*/ ASTContext /*&*/ Context, final /*const*/ CGFunctionInfo /*&*/ FI) {
    this(Context, FI, 
      false);
  }
  public ClangToLLVMArgMapping(final /*const*/ ASTContext /*&*/ Context, final /*const*/ CGFunctionInfo /*&*/ FI, 
      boolean OnlyRequiredArgs/*= false*/) {
    // : InallocaArgNo(InvalidIndex), SRetArgNo(InvalidIndex), TotalIRArgs(0), ArgInfo(OnlyRequiredArgs ? FI.getNumRequiredArgs() : FI.arg_size()) 
    //START JInit
    this.InallocaArgNo = InvalidIndex;
    this.SRetArgNo = InvalidIndex;
    this.TotalIRArgs = 0;
    this.ArgInfo = new SmallVector<IRArgs>(JD$UInt_T$C$R.INSTANCE, 8, OnlyRequiredArgs ? FI.getNumRequiredArgs() : FI.arg_size(), new IRArgs());
    //END JInit
    construct(Context, FI, OnlyRequiredArgs);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClangToLLVMArgMapping::hasInallocaArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 1313,
   FQN="(anonymous namespace)::ClangToLLVMArgMapping::hasInallocaArg", NM="_ZNK12_GLOBAL__N_121ClangToLLVMArgMapping14hasInallocaArgEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK12_GLOBAL__N_121ClangToLLVMArgMapping14hasInallocaArgEv")
  //</editor-fold>
  public boolean hasInallocaArg() /*const*/ {
    return InallocaArgNo != InvalidIndex;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClangToLLVMArgMapping::getInallocaArgNo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 1314,
   FQN="(anonymous namespace)::ClangToLLVMArgMapping::getInallocaArgNo", NM="_ZNK12_GLOBAL__N_121ClangToLLVMArgMapping16getInallocaArgNoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK12_GLOBAL__N_121ClangToLLVMArgMapping16getInallocaArgNoEv")
  //</editor-fold>
  public /*uint*/int getInallocaArgNo() /*const*/ {
    assert (hasInallocaArg());
    return InallocaArgNo;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClangToLLVMArgMapping::hasSRetArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 1319,
   FQN="(anonymous namespace)::ClangToLLVMArgMapping::hasSRetArg", NM="_ZNK12_GLOBAL__N_121ClangToLLVMArgMapping10hasSRetArgEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK12_GLOBAL__N_121ClangToLLVMArgMapping10hasSRetArgEv")
  //</editor-fold>
  public boolean hasSRetArg() /*const*/ {
    return SRetArgNo != InvalidIndex;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClangToLLVMArgMapping::getSRetArgNo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 1320,
   FQN="(anonymous namespace)::ClangToLLVMArgMapping::getSRetArgNo", NM="_ZNK12_GLOBAL__N_121ClangToLLVMArgMapping12getSRetArgNoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK12_GLOBAL__N_121ClangToLLVMArgMapping12getSRetArgNoEv")
  //</editor-fold>
  public /*uint*/int getSRetArgNo() /*const*/ {
    assert (hasSRetArg());
    return SRetArgNo;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClangToLLVMArgMapping::totalIRArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 1325,
   FQN="(anonymous namespace)::ClangToLLVMArgMapping::totalIRArgs", NM="_ZNK12_GLOBAL__N_121ClangToLLVMArgMapping11totalIRArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK12_GLOBAL__N_121ClangToLLVMArgMapping11totalIRArgsEv")
  //</editor-fold>
  public /*uint*/int totalIRArgs() /*const*/ {
    return TotalIRArgs;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClangToLLVMArgMapping::hasPaddingArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 1327,
   FQN="(anonymous namespace)::ClangToLLVMArgMapping::hasPaddingArg", NM="_ZNK12_GLOBAL__N_121ClangToLLVMArgMapping13hasPaddingArgEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK12_GLOBAL__N_121ClangToLLVMArgMapping13hasPaddingArgEj")
  //</editor-fold>
  public boolean hasPaddingArg(/*uint*/int ArgNo) /*const*/ {
    assert ($less_uint(ArgNo, ArgInfo.size()));
    return ArgInfo.$at$Const(ArgNo).PaddingArgIndex != InvalidIndex;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClangToLLVMArgMapping::getPaddingArgNo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 1331,
   FQN="(anonymous namespace)::ClangToLLVMArgMapping::getPaddingArgNo", NM="_ZNK12_GLOBAL__N_121ClangToLLVMArgMapping15getPaddingArgNoEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK12_GLOBAL__N_121ClangToLLVMArgMapping15getPaddingArgNoEj")
  //</editor-fold>
  public /*uint*/int getPaddingArgNo(/*uint*/int ArgNo) /*const*/ {
    assert (hasPaddingArg(ArgNo));
    return ArgInfo.$at$Const(ArgNo).PaddingArgIndex;
  }

  
  /// Returns index of first IR argument corresponding to ArgNo, and their
  /// quantity.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClangToLLVMArgMapping::getIRArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 1338,
   FQN="(anonymous namespace)::ClangToLLVMArgMapping::getIRArgs", NM="_ZNK12_GLOBAL__N_121ClangToLLVMArgMapping9getIRArgsEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK12_GLOBAL__N_121ClangToLLVMArgMapping9getIRArgsEj")
  //</editor-fold>
  public std.pairUIntUInt getIRArgs(/*uint*/int ArgNo) /*const*/ {
    assert ($less_uint(ArgNo, ArgInfo.size()));
    return std.make_pair_uint_uint(ArgInfo.$at$Const(ArgNo).FirstArgIndex, 
        ArgInfo.$at$Const(ArgNo).NumberOfArgs);
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClangToLLVMArgMapping::construct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 1349,
   FQN="(anonymous namespace)::ClangToLLVMArgMapping::construct", NM="_ZN12_GLOBAL__N_121ClangToLLVMArgMapping9constructERKN5clang10ASTContextERKNS1_7CodeGen14CGFunctionInfoEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN12_GLOBAL__N_121ClangToLLVMArgMapping9constructERKN5clang10ASTContextERKNS1_7CodeGen14CGFunctionInfoEb")
  //</editor-fold>
  private void construct(final /*const*/ ASTContext /*&*/ Context, 
           final /*const*/ CGFunctionInfo /*&*/ FI, 
           boolean OnlyRequiredArgs) {
    /*uint*/int IRArgNo = 0;
    boolean SwapThisWithSRet = false;
    final /*const*/ ABIArgInfo /*&*/ RetAI = FI.getReturnInfo$Const();
    if (RetAI.getKind() == ABIArgInfo.Kind.Indirect) {
      SwapThisWithSRet = RetAI.isSRetAfterThis();
      SRetArgNo = SwapThisWithSRet ? 1 : IRArgNo++;
    }
    
    /*uint*/int ArgNo = 0;
    /*uint*/int NumArgs = OnlyRequiredArgs ? FI.getNumRequiredArgs() : FI.arg_size();
    for (type$ptr</*const*/ CGFunctionInfoArgInfo /*P*/ > I = $tryClone(FI.arg_begin$Const()); $less_uint(ArgNo, NumArgs);
         I.$preInc() , ++ArgNo) {
      assert ($noteq_ptr(I, FI.arg_end$Const()));
      QualType ArgType = I./*->*/$star().type.$QualType();
      final /*const*/ ABIArgInfo /*&*/ AI = I./*->*/$star().info;
      // Collect data about IR arguments corresponding to Clang argument ArgNo.
      final IRArgs /*&*/ $IRArgs = ArgInfo.$at(ArgNo);
      if ((AI.getPaddingType() != null)) {
        $IRArgs.PaddingArgIndex = IRArgNo++;
      }
      switch (AI.getKind()) {
       case Extend:
       case Direct:
        {
          // FIXME: handle sseregparm someday...
          StructType /*P*/ STy = dyn_cast_StructType(AI.getCoerceToType());
          if (AI.isDirect() && AI.getCanBeFlattened() && (STy != null)) {
            $IRArgs.NumberOfArgs = STy.getNumElements();
          } else {
            $IRArgs.NumberOfArgs = 1;
          }
          break;
        }
       case Indirect:
        $IRArgs.NumberOfArgs = 1;
        break;
       case Ignore:
       case InAlloca:
        // ignore and inalloca doesn't have matching LLVM parameters.
        $IRArgs.NumberOfArgs = 0;
        break;
       case CoerceAndExpand:
        $IRArgs.NumberOfArgs = AI.getCoerceAndExpandTypeSequence().size();
        break;
       case Expand:
        $IRArgs.NumberOfArgs = getExpansionSize(new QualType(ArgType), Context);
        break;
      }
      if ($greater_uint($IRArgs.NumberOfArgs, 0)) {
        $IRArgs.FirstArgIndex = IRArgNo;
        IRArgNo += $IRArgs.NumberOfArgs;
      }
      
      // Skip over the sret parameter when it comes second.  We already handled it
      // above.
      if (IRArgNo == 1 && SwapThisWithSRet) {
        IRArgNo++;
      }
    }
    assert (ArgNo == ArgInfo.size());
    if (FI.usesInAlloca()) {
      InallocaArgNo = IRArgNo++;
    }
    
    TotalIRArgs = IRArgNo;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClangToLLVMArgMapping::~ClangToLLVMArgMapping">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 1284,
   FQN="(anonymous namespace)::ClangToLLVMArgMapping::~ClangToLLVMArgMapping", NM="_ZN12_GLOBAL__N_121ClangToLLVMArgMappingD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN12_GLOBAL__N_121ClangToLLVMArgMappingD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    ArgInfo.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "InallocaArgNo=" + InallocaArgNo // NOI18N
              + ", SRetArgNo=" + SRetArgNo // NOI18N
              + ", TotalIRArgs=" + TotalIRArgs // NOI18N
              + ", ArgInfo=" + ArgInfo; // NOI18N
  }
}
