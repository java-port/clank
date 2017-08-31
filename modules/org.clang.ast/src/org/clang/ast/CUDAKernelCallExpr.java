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

package org.clang.ast;

import org.clank.support.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;

/// \brief Represents a call to a CUDA kernel function.
//<editor-fold defaultstate="collapsed" desc="clang::CUDAKernelCallExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 160,
 FQN="clang::CUDAKernelCallExpr", NM="_ZN5clang18CUDAKernelCallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang18CUDAKernelCallExprE")
//</editor-fold>
public class CUDAKernelCallExpr extends /*public*/ CallExpr {
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CUDAKernelCallExpr::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 162,
   FQN="clang::CUDAKernelCallExpr::(anonymous)", NM="_ZN5clang18CUDAKernelCallExprE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang18CUDAKernelCallExprE_Unnamed_enum")
  //</editor-fold>
  private enum Unnamed_enum implements Native.ComparableLower {
    CONFIG(0),
    END_PREARG(CONFIG.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Unnamed_enum valueOf(int val) {
      Unnamed_enum out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Unnamed_enum[] VALUES;
      private static final Unnamed_enum[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Unnamed_enum kind : Unnamed_enum.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Unnamed_enum[min < 0 ? (1-min) : 0];
        VALUES = new Unnamed_enum[max >= 0 ? (1+max) : 0];
        for (Unnamed_enum kind : Unnamed_enum.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private Unnamed_enum(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Unnamed_enum)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Unnamed_enum)obj).value);}
    //</editor-fold>
  };
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CUDAKernelCallExpr::CUDAKernelCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 165,
   FQN="clang::CUDAKernelCallExpr::CUDAKernelCallExpr", NM="_ZN5clang18CUDAKernelCallExprC1ERNS_10ASTContextEPNS_4ExprEPNS_8CallExprEN4llvm8ArrayRefIS4_EENS_8QualTypeENS_13ExprValueKindENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang18CUDAKernelCallExprC1ERNS_10ASTContextEPNS_4ExprEPNS_8CallExprEN4llvm8ArrayRefIS4_EENS_8QualTypeENS_13ExprValueKindENS_14SourceLocationE")
  //</editor-fold>
  public CUDAKernelCallExpr(final ASTContext /*&*/ C, Expr /*P*/ fn, CallExpr /*P*/ Config, 
      ArrayRef<Expr /*P*/ > args, QualType t, ExprValueKind VK, 
      SourceLocation RP) {
    // : CallExpr(C, CUDAKernelCallExprClass, fn, Config, args, t, VK, RP) 
    //START JInit
    super(C, StmtClass.CUDAKernelCallExprClass, fn, new ArrayRef<Expr /*P*/ >(Config, true), new ArrayRef<Expr /*P*/ >(args), new QualType(t), VK, new SourceLocation(RP));
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CUDAKernelCallExpr::CUDAKernelCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 170,
   FQN="clang::CUDAKernelCallExpr::CUDAKernelCallExpr", NM="_ZN5clang18CUDAKernelCallExprC1ERNS_10ASTContextENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang18CUDAKernelCallExprC1ERNS_10ASTContextENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public CUDAKernelCallExpr(final ASTContext /*&*/ C, EmptyShell Empty) {
    // : CallExpr(C, CUDAKernelCallExprClass, END_PREARG, Empty) 
    //START JInit
    super(C, StmtClass.CUDAKernelCallExprClass, Unnamed_enum.END_PREARG.getValue(), new EmptyShell(Empty));
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CUDAKernelCallExpr::getConfig">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 173,
   FQN="clang::CUDAKernelCallExpr::getConfig", NM="_ZNK5clang18CUDAKernelCallExpr9getConfigEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang18CUDAKernelCallExpr9getConfigEv")
  //</editor-fold>
  public /*const*/ CallExpr /*P*/ getConfig$Const() /*const*/ {
    return cast_or_null_CallExpr(getPreArg$Const(Unnamed_enum.CONFIG.getValue()));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CUDAKernelCallExpr::getConfig">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 176,
   FQN="clang::CUDAKernelCallExpr::getConfig", NM="_ZN5clang18CUDAKernelCallExpr9getConfigEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang18CUDAKernelCallExpr9getConfigEv")
  //</editor-fold>
  public CallExpr /*P*/ getConfig() {
    return cast_or_null_CallExpr(getPreArg(Unnamed_enum.CONFIG.getValue()));
  }

  
  /// \brief Sets the kernel configuration expression.
  ///
  /// Note that this method cannot be called if config has already been set to a
  /// non-null value.
  //<editor-fold defaultstate="collapsed" desc="clang::CUDAKernelCallExpr::setConfig">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 182,
   FQN="clang::CUDAKernelCallExpr::setConfig", NM="_ZN5clang18CUDAKernelCallExpr9setConfigEPNS_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang18CUDAKernelCallExpr9setConfigEPNS_8CallExprE")
  //</editor-fold>
  public void setConfig(CallExpr /*P*/ E) {
    assert (!(getConfig() != null)) : "Cannot call setConfig if config is not null";
    setPreArg(Unnamed_enum.CONFIG.getValue(), E);
    setInstantiationDependent(isInstantiationDependent()
           || E.isInstantiationDependent());
    setContainsUnexpandedParameterPack(containsUnexpandedParameterPack()
           || E.containsUnexpandedParameterPack());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CUDAKernelCallExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 192,
   FQN="clang::CUDAKernelCallExpr::classof", NM="_ZN5clang18CUDAKernelCallExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang18CUDAKernelCallExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.CUDAKernelCallExprClass;
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
