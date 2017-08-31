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
import static org.llvm.adt.ADTAliases.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import static org.clang.sema.impl.ScopeInfoStatics.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


/// \brief Retains information about a function, method, or block that is
/// currently being parsed.
//<editor-fold defaultstate="collapsed" desc="clang::sema::FunctionScopeInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 81,
 FQN="clang::sema::FunctionScopeInfo", NM="_ZN5clang4sema17FunctionScopeInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema17FunctionScopeInfoE")
//</editor-fold>
public class FunctionScopeInfo implements Destructors.ClassWithDestructor {
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::sema::FunctionScopeInfo::ScopeKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 83,
   FQN="clang::sema::FunctionScopeInfo::ScopeKind", NM="_ZN5clang4sema17FunctionScopeInfo9ScopeKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema17FunctionScopeInfo9ScopeKindE")
  //</editor-fold>
  protected enum ScopeKind implements Native.ComparableLower {
    SK_Function(0),
    SK_Block(SK_Function.getValue() + 1),
    SK_Lambda(SK_Block.getValue() + 1),
    SK_CapturedRegion(SK_Lambda.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ScopeKind valueOf(int val) {
      ScopeKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final ScopeKind[] VALUES;
      private static final ScopeKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ScopeKind kind : ScopeKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ScopeKind[min < 0 ? (1-min) : 0];
        VALUES = new ScopeKind[max >= 0 ? (1+max) : 0];
        for (ScopeKind kind : ScopeKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private ScopeKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((ScopeKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((ScopeKind)obj).value);}
    //</editor-fold>
  };
/*public:*/
  /// \brief What kind of scope we are describing.
  ///
  public ScopeKind Kind /*: 3*/;
  
  /// \brief Whether this function contains a VLA, \@try, try, C++
  /// initializer, or anything else that can't be jumped past.
  public /*JBIT bool*/ boolean HasBranchProtectedScope /*: 1*/;
  
  /// \brief Whether this function contains any switches or direct gotos.
  public /*JBIT bool*/ boolean HasBranchIntoScope /*: 1*/;
  
  /// \brief Whether this function contains any indirect gotos.
  public /*JBIT bool*/ boolean HasIndirectGoto /*: 1*/;
  
  /// \brief Whether a statement was dropped because it was invalid.
  public /*JBIT bool*/ boolean HasDroppedStmt /*: 1*/;
  
  /// \brief True if current scope is for OpenMP declare reduction combiner.
  public boolean HasOMPDeclareReductionCombiner;
  
  /// \brief Whether there is a fallthrough statement in this function.
  public /*JBIT bool*/ boolean HasFallthroughStmt /*: 1*/;
  
  /// A flag that is set when parsing a method that must call super's
  /// implementation, such as \c -dealloc, \c -finalize, or any method marked
  /// with \c __attribute__((objc_requires_super)).
  public /*JBIT bool*/ boolean ObjCShouldCallSuper /*: 1*/;
  
  /// True when this is a method marked as a designated initializer.
  public /*JBIT bool*/ boolean ObjCIsDesignatedInit /*: 1*/;
  /// This starts true for a method marked as designated initializer and will
  /// be set to false if there is an invocation to a designated initializer of
  /// the super class.
  public /*JBIT bool*/ boolean ObjCWarnForNoDesignatedInitChain /*: 1*/;
  
  /// True when this is an initializer method not marked as a designated
  /// initializer within a class that has at least one initializer marked as a
  /// designated initializer.
  public /*JBIT bool*/ boolean ObjCIsSecondaryInit /*: 1*/;
  /// This starts true for a secondary initializer method and will be set to
  /// false if there is an invocation of an initializer on 'self'.
  public /*JBIT bool*/ boolean ObjCWarnForNoInitDelegation /*: 1*/;
  
  /// First 'return' statement in the current function.
  public SourceLocation FirstReturnLoc;
  
  /// First C++ 'try' statement in the current function.
  public SourceLocation FirstCXXTryLoc;
  
  /// First SEH '__try' statement in the current function.
  public SourceLocation FirstSEHTryLoc;
  
  /// \brief Used to determine if errors occurred in this function or block.
  public DiagnosticErrorTrap ErrorTrap;
  
  /// SwitchStack - This is the current set of active switch statements in the
  /// block.
  public SmallVector<SwitchStmt /*P*/ > SwitchStack;
  
  /// \brief The list of return statements that occur within the function or
  /// block, if there is any chance of applying the named return value
  /// optimization, or if we need to infer a return type.
  public SmallVector<ReturnStmt /*P*/ > Returns;
  
  /// \brief The promise object for this coroutine, if any.
  public VarDecl /*P*/ CoroutinePromise;
  
  /// \brief The list of coroutine control flow constructs (co_await, co_yield,
  /// co_return) that occur within the function or block. Empty if and only if
  /// this function or block is not (yet known to be) a coroutine.
  public SmallVector<Stmt /*P*/ > CoroutineStmts;
  
  /// \brief The stack of currently active compound stamement scopes in the
  /// function.
  public SmallVector<CompoundScopeInfo> CompoundScopes;
  
  /// \brief A list of PartialDiagnostics created but delayed within the
  /// current function scope.  These diagnostics are vetted for reachability
  /// prior to being emitted.
  public SmallVector<PossiblyUnreachableDiag> PossiblyUnreachableDiags;
  
  /// \brief A list of parameters which have the nonnull attribute and are
  /// modified in the function.
  public SmallPtrSet</*const*/ ParmVarDecl /*P*/ > ModifiedNonNullParams;
/*public:*/
  /// Represents a simple identification of a weak object.
  ///
  /// Part of the implementation of -Wrepeated-use-of-weak.
  ///
  /// This is used to determine if two weak accesses refer to the same object.
  /// Here are some examples of how various accesses are "profiled":
  ///
  /// Access Expression |     "Base" Decl     |          "Property" Decl
  /// :---------------: | :-----------------: | :------------------------------:
  /// self.property     | self (VarDecl)      | property (ObjCPropertyDecl)
  /// self.implicitProp | self (VarDecl)      | -implicitProp (ObjCMethodDecl)
  /// self->ivar.prop   | ivar (ObjCIvarDecl) | prop (ObjCPropertyDecl)
  /// cxxObj.obj.prop   | obj (FieldDecl)     | prop (ObjCPropertyDecl)
  /// [self foo].prop   | 0 (unknown)         | prop (ObjCPropertyDecl)
  /// self.prop1.prop2  | prop1 (ObjCPropertyDecl)    | prop2 (ObjCPropertyDecl)
  /// MyClass.prop      | MyClass (ObjCInterfaceDecl) | -prop (ObjCMethodDecl)
  /// MyClass.foo.prop  | +foo (ObjCMethodDecl)       | -prop (ObjCPropertyDecl)
  /// weakVar           | 0 (known)           | weakVar (VarDecl)
  /// self->weakIvar    | self (VarDecl)      | weakIvar (ObjCIvarDecl)
  ///
  /// Objects are identified with only two Decls to make it reasonably fast to
  /// compare them.
  //<editor-fold defaultstate="collapsed" desc="clang::sema::FunctionScopeInfo::WeakObjectProfileTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 199,
   FQN="clang::sema::FunctionScopeInfo::WeakObjectProfileTy", NM="_ZN5clang4sema17FunctionScopeInfo19WeakObjectProfileTyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema17FunctionScopeInfo19WeakObjectProfileTyE")
  //</editor-fold>
  public static class WeakObjectProfileTy implements Native.NativeComparable<WeakObjectProfileTy> {
    /// The base object decl, as described in the class documentation.
    ///
    /// The extra flag is "true" if the Base and Property are enough to uniquely
    /// identify the object in memory.
    ///
    /// \sa isExactProfile()
    /*typedef llvm::PointerIntPair<const NamedDecl *, 1, bool> BaseInfoTy*/
//    public final class BaseInfoTy extends PointerBoolPair</*const*/ NamedDecl /*P*/ >{ };
    private PointerBoolPair</*const*/ NamedDecl /*P*/ > Base;
    
    /// The "property" decl, as described in the class documentation.
    ///
    /// Note that this may not actually be an ObjCPropertyDecl, e.g. in the
    /// case of "implicit" properties (regular methods accessed via dot syntax).
    private /*const*/ NamedDecl /*P*/ Property;
    
    /// Used to find the proper base profile for a given base expression.
    //<editor-fold defaultstate="collapsed" desc="clang::sema::FunctionScopeInfo::WeakObjectProfileTy::getBaseInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp", line = 58,
     FQN="clang::sema::FunctionScopeInfo::WeakObjectProfileTy::getBaseInfo", NM="_ZN5clang4sema17FunctionScopeInfo19WeakObjectProfileTy11getBaseInfoEPKNS_4ExprE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema17FunctionScopeInfo19WeakObjectProfileTy11getBaseInfoEPKNS_4ExprE")
    //</editor-fold>
    private static PointerBoolPair</*const*/ NamedDecl /*P*/ > getBaseInfo(/*const*/ Expr /*P*/ E) {
      E = E.IgnoreParenCasts$Const();
      
      /*const*/ NamedDecl /*P*/ D = null;
      boolean IsExact = false;
      switch (E.getStmtClass()) {
       case DeclRefExprClass:
        D = cast_DeclRefExpr(E).getDecl$Const();
        IsExact = isa_VarDecl(D);
        break;
       case MemberExprClass:
        {
          /*const*/ MemberExpr /*P*/ ME = cast_MemberExpr(E);
          D = ME.getMemberDecl();
          IsExact = isa_CXXThisExpr(ME.getBase().IgnoreParenImpCasts());
          break;
        }
       case ObjCIvarRefExprClass:
        {
          /*const*/ ObjCIvarRefExpr /*P*/ IE = cast_ObjCIvarRefExpr(E);
          D = IE.getDecl$Const();
          IsExact = IE.getBase$Const().isObjCSelfExpr();
          break;
        }
       case PseudoObjectExprClass:
        {
          /*const*/ PseudoObjectExpr /*P*/ POE = cast_PseudoObjectExpr(E);
          /*const*/ ObjCPropertyRefExpr /*P*/ BaseProp = dyn_cast_ObjCPropertyRefExpr(POE.getSyntacticForm$Const());
          if ((BaseProp != null)) {
            D = getBestPropertyDecl(BaseProp);
            if (BaseProp.isObjectReceiver()) {
              /*const*/ Expr /*P*/ DoubleBase = BaseProp.getBase$Const();
              {
                /*const*/ OpaqueValueExpr /*P*/ OVE = dyn_cast_OpaqueValueExpr(DoubleBase);
                if ((OVE != null)) {
                  DoubleBase = OVE.getSourceExpr();
                }
              }
              
              IsExact = DoubleBase.isObjCSelfExpr();
            }
          }
          break;
        }
       default:
        break;
      }
      
      return new PointerBoolPair</*const*/ NamedDecl /*P*/ >(D, IsExact);
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::sema::FunctionScopeInfo::WeakObjectProfileTy::WeakObjectProfileTy">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 859,
     FQN="clang::sema::FunctionScopeInfo::WeakObjectProfileTy::WeakObjectProfileTy", NM="_ZN5clang4sema17FunctionScopeInfo19WeakObjectProfileTyC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema17FunctionScopeInfo19WeakObjectProfileTyC1Ev")
    //</editor-fold>
    private WeakObjectProfileTy() {
      // : Base(null, false), Property(null) 
      //START JInit
      this.Base = new PointerBoolPair</*const*/ NamedDecl /*P*/ >((/*const*/ NamedDecl /*P*/ )null, false);
      this.Property = null;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::sema::FunctionScopeInfo::WeakObjectProfileTy::getSentinel">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 862,
     FQN="clang::sema::FunctionScopeInfo::WeakObjectProfileTy::getSentinel", NM="_ZN5clang4sema17FunctionScopeInfo19WeakObjectProfileTy11getSentinelEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema17FunctionScopeInfo19WeakObjectProfileTy11getSentinelEv")
    //</editor-fold>
    private static FunctionScopeInfo.WeakObjectProfileTy getSentinel() {
      FunctionScopeInfo.WeakObjectProfileTy Result/*J*/= new FunctionScopeInfo.WeakObjectProfileTy();
      Result.Base.setInt(true);
      return Result;
    }

  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::sema::FunctionScopeInfo::WeakObjectProfileTy::WeakObjectProfileTy">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp", line = 121,
     FQN="clang::sema::FunctionScopeInfo::WeakObjectProfileTy::WeakObjectProfileTy", NM="_ZN5clang4sema17FunctionScopeInfo19WeakObjectProfileTyC1EPKNS_19ObjCPropertyRefExprE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema17FunctionScopeInfo19WeakObjectProfileTyC1EPKNS_19ObjCPropertyRefExprE")
    //</editor-fold>
    public WeakObjectProfileTy(/*const*/ ObjCPropertyRefExpr /*P*/ PropE) {
      // : Base(null, true), Property(getBestPropertyDecl(PropE)) 
      //START JInit
      this.Base = new PointerBoolPair</*const*/ NamedDecl /*P*/ >((/*const*/ NamedDecl /*P*/ )null, true);
      this.Property = getBestPropertyDecl(PropE);
      //END JInit
      if (PropE.isObjectReceiver()) {
        /*const*/ OpaqueValueExpr /*P*/ OVE = cast_OpaqueValueExpr(PropE.getBase$Const());
        /*const*/ Expr /*P*/ E = OVE.getSourceExpr();
        Base.$assignMove(getBaseInfo(E));
      } else if (PropE.isClassReceiver()) {
        Base.setPointer(PropE.getClassReceiver());
      } else {
        assert (PropE.isSuperReceiver());
      }
    }

    //<editor-fold defaultstate="collapsed" desc="clang::sema::FunctionScopeInfo::WeakObjectProfileTy::WeakObjectProfileTy">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp", line = 136,
     FQN="clang::sema::FunctionScopeInfo::WeakObjectProfileTy::WeakObjectProfileTy", NM="_ZN5clang4sema17FunctionScopeInfo19WeakObjectProfileTyC1EPKNS_4ExprEPKNS_16ObjCPropertyDeclE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema17FunctionScopeInfo19WeakObjectProfileTyC1EPKNS_4ExprEPKNS_16ObjCPropertyDeclE")
    //</editor-fold>
    public WeakObjectProfileTy(/*const*/ Expr /*P*/ BaseE, 
        /*const*/ ObjCPropertyDecl /*P*/ Prop) {
      // : Base(null, true), Property(Prop) 
      //START JInit
      this.Base = new PointerBoolPair</*const*/ NamedDecl /*P*/ >((/*const*/ NamedDecl /*P*/ )null, true);
      this.Property = Prop;
      //END JInit
      if ((BaseE != null)) {
        Base.$assignMove(getBaseInfo(BaseE));
      }
      // else, this is a message accessing a property on super.
    }

    //<editor-fold defaultstate="collapsed" desc="clang::sema::FunctionScopeInfo::WeakObjectProfileTy::WeakObjectProfileTy">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp", line = 144,
     FQN="clang::sema::FunctionScopeInfo::WeakObjectProfileTy::WeakObjectProfileTy", NM="_ZN5clang4sema17FunctionScopeInfo19WeakObjectProfileTyC1EPKNS_11DeclRefExprE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema17FunctionScopeInfo19WeakObjectProfileTyC1EPKNS_11DeclRefExprE")
    //</editor-fold>
    public WeakObjectProfileTy(/*const*/ DeclRefExpr /*P*/ DRE) {
      // : Base(null, true), Property(DRE->getDecl()) 
      //START JInit
      this.Base = new PointerBoolPair</*const*/ NamedDecl /*P*/ >((/*const*/ NamedDecl /*P*/ )null, true);
      this.Property = DRE.getDecl$Const();
      //END JInit
      assert (isa_VarDecl(Property));
    }

    //<editor-fold defaultstate="collapsed" desc="clang::sema::FunctionScopeInfo::WeakObjectProfileTy::WeakObjectProfileTy">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp", line = 150,
     FQN="clang::sema::FunctionScopeInfo::WeakObjectProfileTy::WeakObjectProfileTy", NM="_ZN5clang4sema17FunctionScopeInfo19WeakObjectProfileTyC1EPKNS_15ObjCIvarRefExprE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema17FunctionScopeInfo19WeakObjectProfileTyC1EPKNS_15ObjCIvarRefExprE")
    //</editor-fold>
    public WeakObjectProfileTy(/*const*/ ObjCIvarRefExpr /*P*/ IvarE) {
      // : Base(getBaseInfo(IvarE->getBase())), Property(IvarE->getDecl()) 
      //START JInit
      this.Base = getBaseInfo(IvarE.getBase$Const());
      this.Property = IvarE.getDecl$Const();
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::sema::FunctionScopeInfo::WeakObjectProfileTy::getBase">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 227,
     FQN="clang::sema::FunctionScopeInfo::WeakObjectProfileTy::getBase", NM="_ZNK5clang4sema17FunctionScopeInfo19WeakObjectProfileTy7getBaseEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZNK5clang4sema17FunctionScopeInfo19WeakObjectProfileTy7getBaseEv")
    //</editor-fold>
    public /*const*/ NamedDecl /*P*/ getBase() /*const*/ {
      return Base.getPointer();
    }

    //<editor-fold defaultstate="collapsed" desc="clang::sema::FunctionScopeInfo::WeakObjectProfileTy::getProperty">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 228,
     FQN="clang::sema::FunctionScopeInfo::WeakObjectProfileTy::getProperty", NM="_ZNK5clang4sema17FunctionScopeInfo19WeakObjectProfileTy11getPropertyEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZNK5clang4sema17FunctionScopeInfo19WeakObjectProfileTy11getPropertyEv")
    //</editor-fold>
    public /*const*/ NamedDecl /*P*/ getProperty() /*const*/ {
      return Property;
    }

    
    /// Returns true if the object base specifies a known object in memory,
    /// rather than, say, an instance variable or property of another object.
    ///
    /// Note that this ignores the effects of aliasing; that is, \c foo.bar is
    /// considered an exact profile if \c foo is a local variable, even if
    /// another variable \c foo2 refers to the same object as \c foo.
    ///
    /// For increased precision, accesses with base variables that are
    /// properties or ivars of 'self' (e.g. self.prop1.prop2) are considered to
    /// be exact, though this is not true for arbitrary variables
    /// (foo.prop1.prop2).
    //<editor-fold defaultstate="collapsed" desc="clang::sema::FunctionScopeInfo::WeakObjectProfileTy::isExactProfile">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 241,
     FQN="clang::sema::FunctionScopeInfo::WeakObjectProfileTy::isExactProfile", NM="_ZNK5clang4sema17FunctionScopeInfo19WeakObjectProfileTy14isExactProfileEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZNK5clang4sema17FunctionScopeInfo19WeakObjectProfileTy14isExactProfileEv")
    //</editor-fold>
    public boolean isExactProfile() /*const*/ {
      return Base.getInt();
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::sema::FunctionScopeInfo::WeakObjectProfileTy::operator==">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 245,
     FQN="clang::sema::FunctionScopeInfo::WeakObjectProfileTy::operator==", NM="_ZNK5clang4sema17FunctionScopeInfo19WeakObjectProfileTyeqERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZNK5clang4sema17FunctionScopeInfo19WeakObjectProfileTyeqERKS2_")
    //</editor-fold>
    public boolean $eq(final /*const*/ WeakObjectProfileTy /*&*/ Other) /*const*/ {
      return Base.$eq(Other.Base) && Property == Other.Property;
    }

    
    // For use in DenseMap.
    // We can't specialize the usual llvm::DenseMapInfo at the end of the file
    // because by that point the DenseMap in FunctionScopeInfo has already been
    // instantiated.
    //<editor-fold defaultstate="collapsed" desc="clang::sema::FunctionScopeInfo::WeakObjectProfileTy::DenseMapInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 253,
     FQN="clang::sema::FunctionScopeInfo::WeakObjectProfileTy::DenseMapInfo", NM="_ZN5clang4sema17FunctionScopeInfo19WeakObjectProfileTy12DenseMapInfoE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema17FunctionScopeInfo19WeakObjectProfileTy12DenseMapInfoE")
    //</editor-fold>
    public static class DenseMapInfo implements org.llvm.adt.DenseMapInfo<WeakObjectProfileTy> {
      private static final DenseMapInfo INFO = new DenseMapInfo();
      public static DenseMapInfo $Info() {
        return INFO;
      }

      private final WeakObjectProfileTy EmptyKey = new WeakObjectProfileTy();
      private final WeakObjectProfileTy TombstoneKey = WeakObjectProfileTy.getSentinel();
      private final DenseMapInfoPair<PointerBoolPair</*const*/ NamedDecl /*P*/ >, /*const*/ NamedDecl /*P*/ > Helper;
      private DenseMapInfo() {
//        DenseMapInfoPairTypePtrBool</*const*/ NamedDecl /*P*/ > forPtrBoolPair = DenseMapInfoPairTypePtrBool.</*const*/ NamedDecl /*P*/ >$Info();
//        this.Helper = new DenseMapInfoPair<PointerBoolPair</*const*/ NamedDecl /*P*/ >, /*const*/ NamedDecl /*P*/ >(forPtrBoolPair, DenseMapInfo$LikePtr.</*const*/ NamedDecl /*P*/>$Info());
        this.Helper = null;
      }
      
    /*public:*/
      //<editor-fold defaultstate="collapsed" desc="clang::sema::FunctionScopeInfo::WeakObjectProfileTy::DenseMapInfo::getEmptyKey">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 255,
       FQN="clang::sema::FunctionScopeInfo::WeakObjectProfileTy::DenseMapInfo::getEmptyKey", NM="_ZN5clang4sema17FunctionScopeInfo19WeakObjectProfileTy12DenseMapInfo11getEmptyKeyEv",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema17FunctionScopeInfo19WeakObjectProfileTy12DenseMapInfo11getEmptyKeyEv")
      //</editor-fold>
      public /*inline*/ WeakObjectProfileTy getEmptyKey() {
        return EmptyKey;
      }

      //<editor-fold defaultstate="collapsed" desc="clang::sema::FunctionScopeInfo::WeakObjectProfileTy::DenseMapInfo::getTombstoneKey">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 258,
       FQN="clang::sema::FunctionScopeInfo::WeakObjectProfileTy::DenseMapInfo::getTombstoneKey", NM="_ZN5clang4sema17FunctionScopeInfo19WeakObjectProfileTy12DenseMapInfo15getTombstoneKeyEv",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema17FunctionScopeInfo19WeakObjectProfileTy12DenseMapInfo15getTombstoneKeyEv")
      //</editor-fold>
      public /*inline*/ WeakObjectProfileTy getTombstoneKey() {
        return TombstoneKey;
      }

      
      //<editor-fold defaultstate="collapsed" desc="clang::sema::FunctionScopeInfo::WeakObjectProfileTy::DenseMapInfo::getHashValue">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 262,
       FQN="clang::sema::FunctionScopeInfo::WeakObjectProfileTy::DenseMapInfo::getHashValue", NM="_ZN5clang4sema17FunctionScopeInfo19WeakObjectProfileTy12DenseMapInfo12getHashValueERKS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema17FunctionScopeInfo19WeakObjectProfileTy12DenseMapInfo12getHashValueERKS2_")
      //</editor-fold>
      public /*uint*/int getHashValue(final /*const*/ WeakObjectProfileTy /*&*/ Val) {
        /*typedef std::pair<BaseInfoTy, const NamedDecl *> Pair*/
//        final class Pair extends std.pair<PointerBoolPair</*const*/ NamedDecl /*P*/ >, /*const*/ NamedDecl /*P*/ >{ };
        return Helper.getHashValue(new std.pairTypePtr<PointerBoolPair</*const*/ NamedDecl /*P*/ >, /*const*/ NamedDecl /*P*/ >(Val.Base, 
                Val.Property));
      }

      
      //<editor-fold defaultstate="collapsed" desc="clang::sema::FunctionScopeInfo::WeakObjectProfileTy::DenseMapInfo::isEqual">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 268,
       FQN="clang::sema::FunctionScopeInfo::WeakObjectProfileTy::DenseMapInfo::isEqual", NM="_ZN5clang4sema17FunctionScopeInfo19WeakObjectProfileTy12DenseMapInfo7isEqualERKS2_S5_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema17FunctionScopeInfo19WeakObjectProfileTy12DenseMapInfo7isEqualERKS2_S5_")
      //</editor-fold>
      public boolean isEqual(final /*const*/ WeakObjectProfileTy /*&*/ LHS, 
             final /*const*/ WeakObjectProfileTy /*&*/ RHS) {
        return LHS.$eq(RHS);
      }

      
      @Override public String toString() {
        return ""; // NOI18N
      }

      @Override
      public boolean isKeyPointerLike() {
        return false;
      }
    };
    //<editor-fold defaultstate="collapsed" desc="clang::sema::FunctionScopeInfo::WeakObjectProfileTy::WeakObjectProfileTy">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 199,
     FQN="clang::sema::FunctionScopeInfo::WeakObjectProfileTy::WeakObjectProfileTy", NM="_ZN5clang4sema17FunctionScopeInfo19WeakObjectProfileTyC1ERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema17FunctionScopeInfo19WeakObjectProfileTyC1ERKS2_")
    //</editor-fold>
    public /*inline*/ WeakObjectProfileTy(final /*const*/ WeakObjectProfileTy /*&*/ $Prm0) {
      // : Base(.Base), Property(.Property) 
      //START JInit
      this.Base = new PointerBoolPair</*const*/ NamedDecl /*P*/ >($Prm0.Base);
      this.Property = $Prm0.Property;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::sema::FunctionScopeInfo::WeakObjectProfileTy::WeakObjectProfileTy">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 199,
     FQN="clang::sema::FunctionScopeInfo::WeakObjectProfileTy::WeakObjectProfileTy", NM="_ZN5clang4sema17FunctionScopeInfo19WeakObjectProfileTyC1EOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema17FunctionScopeInfo19WeakObjectProfileTyC1EOS2_")
    //</editor-fold>
    public /*inline*/ WeakObjectProfileTy(JD$Move _dparam, final WeakObjectProfileTy /*&&*/$Prm0) {
      // : Base(static_cast<WeakObjectProfileTy &&>().Base), Property(static_cast<WeakObjectProfileTy &&>().Property) 
      //START JInit
      this.Base = new PointerBoolPair</*const*/ NamedDecl /*P*/ >(JD$Move.INSTANCE, $Prm0.Base);
      this.Property = $Prm0.Property;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::sema::FunctionScopeInfo::WeakObjectProfileTy::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 199,
     FQN="clang::sema::FunctionScopeInfo::WeakObjectProfileTy::operator=", NM="_ZN5clang4sema17FunctionScopeInfo19WeakObjectProfileTyaSERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema17FunctionScopeInfo19WeakObjectProfileTyaSERKS2_")
    //</editor-fold>
    public /*inline*/ WeakObjectProfileTy /*&*/ $assign(final /*const*/ WeakObjectProfileTy /*&*/ $Prm0) {
      this.Base.$assign($Prm0.Base);
      this.Property = $Prm0.Property;
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::sema::FunctionScopeInfo::WeakObjectProfileTy::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 199,
     FQN="clang::sema::FunctionScopeInfo::WeakObjectProfileTy::operator=", NM="_ZN5clang4sema17FunctionScopeInfo19WeakObjectProfileTyaSEOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema17FunctionScopeInfo19WeakObjectProfileTyaSEOS2_")
    //</editor-fold>
    public /*inline*/ WeakObjectProfileTy /*&*/ $assignMove(final WeakObjectProfileTy /*&&*/$Prm0) {
      this.Base.$assignMove($Prm0.Base);
      this.Property = $Prm0.Property;
      return /*Deref*/this;
    }

    
    @Override public String toString() {
      return "" + "Base=" + Base // NOI18N
                + ", Property=" + Property; // NOI18N
    }
  };
  
  /// Represents a single use of a weak object.
  ///
  /// Stores both the expression and whether the access is potentially unsafe
  /// (i.e. it could potentially be warned about).
  ///
  /// Part of the implementation of -Wrepeated-use-of-weak.
  //<editor-fold defaultstate="collapsed" desc="clang::sema::FunctionScopeInfo::WeakUseTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 281,
   FQN="clang::sema::FunctionScopeInfo::WeakUseTy", NM="_ZN5clang4sema17FunctionScopeInfo9WeakUseTyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema17FunctionScopeInfo9WeakUseTyE")
  //</editor-fold>
  public static class WeakUseTy implements Native.NativeComparable<WeakUseTy>, Native.NativePOD<WeakUseTy> {
    private PointerBoolPair</*const*/ Expr /*P*/ > Rep;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::sema::FunctionScopeInfo::WeakUseTy::WeakUseTy">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 284,
     FQN="clang::sema::FunctionScopeInfo::WeakUseTy::WeakUseTy", NM="_ZN5clang4sema17FunctionScopeInfo9WeakUseTyC1EPKNS_4ExprEb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema17FunctionScopeInfo9WeakUseTyC1EPKNS_4ExprEb")
    //</editor-fold>
    public WeakUseTy(/*const*/ Expr /*P*/ Use, boolean IsRead) {
      // : Rep(Use, IsRead) 
      //START JInit
      this.Rep = new PointerBoolPair</*const*/ Expr /*P*/ >(Use, IsRead);
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::sema::FunctionScopeInfo::WeakUseTy::getUseExpr">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 286,
     FQN="clang::sema::FunctionScopeInfo::WeakUseTy::getUseExpr", NM="_ZNK5clang4sema17FunctionScopeInfo9WeakUseTy10getUseExprEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZNK5clang4sema17FunctionScopeInfo9WeakUseTy10getUseExprEv")
    //</editor-fold>
    public /*const*/ Expr /*P*/ getUseExpr() /*const*/ {
      return Rep.getPointer();
    }

    //<editor-fold defaultstate="collapsed" desc="clang::sema::FunctionScopeInfo::WeakUseTy::isUnsafe">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 287,
     FQN="clang::sema::FunctionScopeInfo::WeakUseTy::isUnsafe", NM="_ZNK5clang4sema17FunctionScopeInfo9WeakUseTy8isUnsafeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZNK5clang4sema17FunctionScopeInfo9WeakUseTy8isUnsafeEv")
    //</editor-fold>
    public boolean isUnsafe() /*const*/ {
      return Rep.getInt();
    }

    //<editor-fold defaultstate="collapsed" desc="clang::sema::FunctionScopeInfo::WeakUseTy::markSafe">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 288,
     FQN="clang::sema::FunctionScopeInfo::WeakUseTy::markSafe", NM="_ZN5clang4sema17FunctionScopeInfo9WeakUseTy8markSafeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema17FunctionScopeInfo9WeakUseTy8markSafeEv")
    //</editor-fold>
    public void markSafe() {
      Rep.setInt(false);
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::sema::FunctionScopeInfo::WeakUseTy::operator==">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 290,
     FQN="clang::sema::FunctionScopeInfo::WeakUseTy::operator==", NM="_ZNK5clang4sema17FunctionScopeInfo9WeakUseTyeqERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZNK5clang4sema17FunctionScopeInfo9WeakUseTyeqERKS2_")
    //</editor-fold>
    public boolean $eq(final /*const*/ WeakUseTy /*&*/ Other) /*const*/ {
      return Rep.$eq(Other.Rep);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::sema::FunctionScopeInfo::WeakUseTy::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 281,
     FQN="clang::sema::FunctionScopeInfo::WeakUseTy::operator=", NM="_ZN5clang4sema17FunctionScopeInfo9WeakUseTyaSEOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema17FunctionScopeInfo9WeakUseTyaSEOS2_")
    //</editor-fold>
    public /*inline*/ WeakUseTy /*&*/ $assignMove(final WeakUseTy /*&&*/$Prm0) {
      this.Rep.$assignMove($Prm0.Rep);
      return /*Deref*/this;
    }


    //<editor-fold defaultstate="collapsed" desc="clang::sema::FunctionScopeInfo::WeakUseTy::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 281,
     FQN="clang::sema::FunctionScopeInfo::WeakUseTy::operator=", NM="_ZN5clang4sema17FunctionScopeInfo9WeakUseTyaSERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4sema17FunctionScopeInfo9WeakUseTyaSERKS2_")
    //</editor-fold>
    public /*inline*/ WeakUseTy /*&*/ $assign(final /*const*/ WeakUseTy /*&*/ $Prm0) {
      this.Rep.$assign($Prm0.Rep);
      return /*Deref*/this;
    }

    public WeakUseTy() {
      this.Rep = new PointerBoolPair<>();
    }
    
    @Override
    public WeakUseTy clone() {
      return new WeakUseTy(Rep.getPointer(), Rep.getBool());
    }

    @Override public String toString() {
      return "" + "Rep=" + Rep; // NOI18N
    }
  };
  
  /// Used to collect uses of a particular weak object in a function body.
  ///
  /// Part of the implementation of -Wrepeated-use-of-weak.
  /*typedef SmallVector<WeakUseTy, 4> WeakUseVector*/
//  public final class WeakUseVector extends SmallVector<WeakUseTy>{ };
  
  /// Used to collect all uses of weak objects in a function body.
  ///
  /// Part of the implementation of -Wrepeated-use-of-weak.
  /*typedef llvm::SmallDenseMap<WeakObjectProfileTy, WeakUseVector, 8, WeakObjectProfileTy::DenseMapInfo> WeakObjectUseMap*/
//  public final class WeakObjectUseMap extends SmallDenseMap<WeakObjectProfileTy, SmallVector<WeakUseTy>>{ };
/*private:*/
  /// Used to collect all uses of weak objects in this function body.
  ///
  /// Part of the implementation of -Wrepeated-use-of-weak.
  private SmallDenseMap<WeakObjectProfileTy, SmallVector<WeakUseTy>> WeakObjectUses;
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::sema::FunctionScopeInfo::FunctionScopeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 314,
   FQN="clang::sema::FunctionScopeInfo::FunctionScopeInfo", NM="_ZN5clang4sema17FunctionScopeInfoC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4sema17FunctionScopeInfoC1ERKS1_")
  //</editor-fold>
  protected FunctionScopeInfo(final /*const*/ FunctionScopeInfo /*&*/ $Prm0) {
    // : Kind(.Kind), HasBranchProtectedScope(.HasBranchProtectedScope), HasBranchIntoScope(.HasBranchIntoScope), HasIndirectGoto(.HasIndirectGoto), HasDroppedStmt(.HasDroppedStmt), HasOMPDeclareReductionCombiner(.HasOMPDeclareReductionCombiner), HasFallthroughStmt(.HasFallthroughStmt), ObjCShouldCallSuper(.ObjCShouldCallSuper), ObjCIsDesignatedInit(.ObjCIsDesignatedInit), ObjCWarnForNoDesignatedInitChain(.ObjCWarnForNoDesignatedInitChain), ObjCIsSecondaryInit(.ObjCIsSecondaryInit), ObjCWarnForNoInitDelegation(.ObjCWarnForNoInitDelegation), FirstReturnLoc(.FirstReturnLoc), FirstCXXTryLoc(.FirstCXXTryLoc), FirstSEHTryLoc(.FirstSEHTryLoc), ErrorTrap(.ErrorTrap), SwitchStack(.SwitchStack), Returns(.Returns), CoroutinePromise(.CoroutinePromise), CoroutineStmts(.CoroutineStmts), CompoundScopes(.CompoundScopes), PossiblyUnreachableDiags(.PossiblyUnreachableDiags), ModifiedNonNullParams(.ModifiedNonNullParams), WeakObjectUses(.WeakObjectUses)/* = default*/ 
    //START JInit
    this.Kind = $Prm0.Kind;
    this.HasBranchProtectedScope = $Prm0.HasBranchProtectedScope;
    this.HasBranchIntoScope = $Prm0.HasBranchIntoScope;
    this.HasIndirectGoto = $Prm0.HasIndirectGoto;
    this.HasDroppedStmt = $Prm0.HasDroppedStmt;
    this.HasOMPDeclareReductionCombiner = $Prm0.HasOMPDeclareReductionCombiner;
    this.HasFallthroughStmt = $Prm0.HasFallthroughStmt;
    this.ObjCShouldCallSuper = $Prm0.ObjCShouldCallSuper;
    this.ObjCIsDesignatedInit = $Prm0.ObjCIsDesignatedInit;
    this.ObjCWarnForNoDesignatedInitChain = $Prm0.ObjCWarnForNoDesignatedInitChain;
    this.ObjCIsSecondaryInit = $Prm0.ObjCIsSecondaryInit;
    this.ObjCWarnForNoInitDelegation = $Prm0.ObjCWarnForNoInitDelegation;
    this.FirstReturnLoc = new SourceLocation($Prm0.FirstReturnLoc);
    this.FirstCXXTryLoc = new SourceLocation($Prm0.FirstCXXTryLoc);
    this.FirstSEHTryLoc = new SourceLocation($Prm0.FirstSEHTryLoc);
    this.ErrorTrap = new DiagnosticErrorTrap($Prm0.ErrorTrap);
    this.SwitchStack = new SmallVector<SwitchStmt /*P*/ >($Prm0.SwitchStack);
    this.Returns = new SmallVector<ReturnStmt /*P*/ >($Prm0.Returns);
    this.CoroutinePromise = $Prm0.CoroutinePromise;
    this.CoroutineStmts = new SmallVector<Stmt /*P*/ >($Prm0.CoroutineStmts);
    this.CompoundScopes = new SmallVector<CompoundScopeInfo>($Prm0.CompoundScopes);
    this.PossiblyUnreachableDiags = new SmallVector<PossiblyUnreachableDiag>($Prm0.PossiblyUnreachableDiags);
    this.ModifiedNonNullParams = new SmallPtrSet</*const*/ ParmVarDecl /*P*/ >($Prm0.ModifiedNonNullParams);
    this.WeakObjectUses = new SmallDenseMap<WeakObjectProfileTy, SmallVector<WeakUseTy>>($Prm0.WeakObjectUses);
    //END JInit
  }


/*public:*/
  /// Record that a weak object was accessed.
  ///
  /// Part of the implementation of -Wrepeated-use-of-weak.
  /*template <typename ExprT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::sema::FunctionScopeInfo::recordUseOfWeak">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*different instances are passed here*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 870,
   FQN="clang::sema::FunctionScopeInfo::recordUseOfWeak", NM="Tpl__ZN5clang4sema17FunctionScopeInfo15recordUseOfWeakEPKT_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=Tpl__ZN5clang4sema17FunctionScopeInfo15recordUseOfWeakEPKT_b")
  //</editor-fold>
  public </*typename*/ ExprT extends Expr> void recordUseOfWeak$T(/*const*/ ExprT /*P*/ E) {
    recordUseOfWeak$T(E, true);
  }
  public </*typename*/ ExprT extends Expr> void recordUseOfWeak$T(/*const*/ ExprT /*P*/ E, boolean IsRead/*= true*/) {
    assert Native.$bool(E);
    final SmallVector<WeakUseTy> /*&*/ Uses;
    if (E instanceof ObjCPropertyRefExpr) {
      Uses = WeakObjectUses.$at_T1$RR(new WeakObjectProfileTy((ObjCPropertyRefExpr)E));
    } else if (E instanceof DeclRefExpr) {
      Uses = WeakObjectUses.$at_T1$RR(new WeakObjectProfileTy((DeclRefExpr)E));
    } else {
      assert false : "Expr of Unexpected class " + (E == null ? "" : E.getClass());
      Uses = null;
    }
    Uses.push_back(new WeakUseTy(E, IsRead));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::FunctionScopeInfo::recordUseOfWeak">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp", line = 155,
   FQN="clang::sema::FunctionScopeInfo::recordUseOfWeak", NM="_ZN5clang4sema17FunctionScopeInfo15recordUseOfWeakEPKNS_15ObjCMessageExprEPKNS_16ObjCPropertyDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema17FunctionScopeInfo15recordUseOfWeakEPKNS_15ObjCMessageExprEPKNS_16ObjCPropertyDeclE")
  //</editor-fold>
  public void recordUseOfWeak(/*const*/ ObjCMessageExpr /*P*/ Msg, 
                 /*const*/ ObjCPropertyDecl /*P*/ Prop) {
    assert ((Msg != null) && (Prop != null));
    final SmallVector<WeakUseTy> /*&*/ Uses = WeakObjectUses.$at_T1$RR(new WeakObjectProfileTy(Msg.getInstanceReceiver$Const(), Prop));
    Uses.push_back(new WeakUseTy(Msg, Msg.getNumArgs() == 0));
  }

  
  /// Record that a given expression is a "safe" access of a weak object (e.g.
  /// assigning it to a strong variable.)
  ///
  /// Part of the implementation of -Wrepeated-use-of-weak.
  //<editor-fold defaultstate="collapsed" desc="clang::sema::FunctionScopeInfo::markSafeWeakUse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp", line = 163,
   FQN="clang::sema::FunctionScopeInfo::markSafeWeakUse", NM="_ZN5clang4sema17FunctionScopeInfo15markSafeWeakUseEPKNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema17FunctionScopeInfo15markSafeWeakUseEPKNS_4ExprE")
  //</editor-fold>
  public void markSafeWeakUse(/*const*/ Expr /*P*/ E) {
    E = E.IgnoreParenCasts$Const();
    {
      
      /*const*/ PseudoObjectExpr /*P*/ POE = dyn_cast_PseudoObjectExpr(E);
      if ((POE != null)) {
        markSafeWeakUse(POE.getSyntacticForm$Const());
        return;
      }
    }
    {
      
      /*const*/ ConditionalOperator /*P*/ Cond = dyn_cast_ConditionalOperator(E);
      if ((Cond != null)) {
        markSafeWeakUse(Cond.getTrueExpr());
        markSafeWeakUse(Cond.getFalseExpr());
        return;
      }
    }
    {
      
      /*const*/ BinaryConditionalOperator /*P*/ Cond = dyn_cast_BinaryConditionalOperator(E);
      if ((Cond != null)) {
        markSafeWeakUse(Cond.getCommon());
        markSafeWeakUse(Cond.getFalseExpr());
        return;
      }
    }
    
    // Has this weak object been seen before?
    DenseMapIterator<WeakObjectProfileTy, SmallVector<WeakUseTy>> Uses/*J*/= 
            new DenseMapIterator<WeakObjectProfileTy, SmallVector<WeakUseTy>>(FunctionScopeInfo.WeakObjectProfileTy.DenseMapInfo.$Info());
    {
      /*const*/ ObjCPropertyRefExpr /*P*/ RefExpr = dyn_cast_ObjCPropertyRefExpr(E);
      if ((RefExpr != null)) {
        if (!RefExpr.isObjectReceiver()) {
          return;
        }
        if (isa_OpaqueValueExpr(RefExpr.getBase$Const())) {
          Uses.$assignMove(WeakObjectUses.find(new WeakObjectProfileTy(RefExpr)));
        } else {
          markSafeWeakUse(RefExpr.getBase$Const());
          return;
        }
      } else {
        /*const*/ ObjCIvarRefExpr /*P*/ IvarE = dyn_cast_ObjCIvarRefExpr(E);
        if ((IvarE != null)) {
          Uses.$assignMove(WeakObjectUses.find(new WeakObjectProfileTy(IvarE)));
        } else {
          /*const*/ DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(E);
          if ((DRE != null)) {
            Uses.$assignMove(WeakObjectUses.find(new WeakObjectProfileTy(DRE)));
          } else {
            /*const*/ ObjCMessageExpr /*P*/ MsgE = dyn_cast_ObjCMessageExpr(E);
            if ((MsgE != null)) {
              Uses.$assignMove(WeakObjectUses.end());
              {
                /*const*/ ObjCMethodDecl /*P*/ MD = MsgE.getMethodDecl$Const();
                if ((MD != null)) {
                  {
                    /*const*/ ObjCPropertyDecl /*P*/ Prop = MD.findPropertyDecl();
                    if ((Prop != null)) {
                      Uses.$assignMove(
                          WeakObjectUses.find(new WeakObjectProfileTy(MsgE.getInstanceReceiver$Const(), 
                                  Prop))
                      );
                    }
                  }
                }
              }
            } else {
              return;
            }
          }
        }
      }
    }
    if (Uses.$eq(/*NO_ITER_COPY*/WeakObjectUses.end())) {
      return;
    }
    
    // Has there been a read from the object using this Expr?
    type$iterator<?, WeakUseTy /*P*/> ThisUse = llvm.find(llvm.reverse$NotHasRBegin(Uses.$arrow().second), new WeakUseTy(E, true));
    if ($eq_reverse_iterator$C(ThisUse, Uses.$arrow().second.rend())) {
      return;
    }
    
    ThisUse.$arrow().markSafe();
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::FunctionScopeInfo::getWeakObjectUses">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 332,
   FQN="clang::sema::FunctionScopeInfo::getWeakObjectUses", NM="_ZNK5clang4sema17FunctionScopeInfo17getWeakObjectUsesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZNK5clang4sema17FunctionScopeInfo17getWeakObjectUsesEv")
  //</editor-fold>
  public /*const*/SmallDenseMap<WeakObjectProfileTy, SmallVector<WeakUseTy>> /*&*/ getWeakObjectUses() /*const*/ {
    return WeakObjectUses;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::FunctionScopeInfo::setHasBranchIntoScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 336,
   FQN="clang::sema::FunctionScopeInfo::setHasBranchIntoScope", NM="_ZN5clang4sema17FunctionScopeInfo21setHasBranchIntoScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema17FunctionScopeInfo21setHasBranchIntoScopeEv")
  //</editor-fold>
  public void setHasBranchIntoScope() {
    HasBranchIntoScope = true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::FunctionScopeInfo::setHasBranchProtectedScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 340,
   FQN="clang::sema::FunctionScopeInfo::setHasBranchProtectedScope", NM="_ZN5clang4sema17FunctionScopeInfo26setHasBranchProtectedScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema17FunctionScopeInfo26setHasBranchProtectedScopeEv")
  //</editor-fold>
  public void setHasBranchProtectedScope() {
    HasBranchProtectedScope = true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::FunctionScopeInfo::setHasIndirectGoto">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 344,
   FQN="clang::sema::FunctionScopeInfo::setHasIndirectGoto", NM="_ZN5clang4sema17FunctionScopeInfo18setHasIndirectGotoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema17FunctionScopeInfo18setHasIndirectGotoEv")
  //</editor-fold>
  public void setHasIndirectGoto() {
    HasIndirectGoto = true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::FunctionScopeInfo::setHasDroppedStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 348,
   FQN="clang::sema::FunctionScopeInfo::setHasDroppedStmt", NM="_ZN5clang4sema17FunctionScopeInfo17setHasDroppedStmtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema17FunctionScopeInfo17setHasDroppedStmtEv")
  //</editor-fold>
  public void setHasDroppedStmt() {
    HasDroppedStmt = true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::FunctionScopeInfo::setHasOMPDeclareReductionCombiner">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 352,
   FQN="clang::sema::FunctionScopeInfo::setHasOMPDeclareReductionCombiner", NM="_ZN5clang4sema17FunctionScopeInfo33setHasOMPDeclareReductionCombinerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema17FunctionScopeInfo33setHasOMPDeclareReductionCombinerEv")
  //</editor-fold>
  public void setHasOMPDeclareReductionCombiner() {
    HasOMPDeclareReductionCombiner = true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::FunctionScopeInfo::setHasFallthroughStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 356,
   FQN="clang::sema::FunctionScopeInfo::setHasFallthroughStmt", NM="_ZN5clang4sema17FunctionScopeInfo21setHasFallthroughStmtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema17FunctionScopeInfo21setHasFallthroughStmtEv")
  //</editor-fold>
  public void setHasFallthroughStmt() {
    HasFallthroughStmt = true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::FunctionScopeInfo::setHasCXXTry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 360,
   FQN="clang::sema::FunctionScopeInfo::setHasCXXTry", NM="_ZN5clang4sema17FunctionScopeInfo12setHasCXXTryENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema17FunctionScopeInfo12setHasCXXTryENS_14SourceLocationE")
  //</editor-fold>
  public void setHasCXXTry(SourceLocation TryLoc) {
    setHasBranchProtectedScope();
    FirstCXXTryLoc.$assign(TryLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::FunctionScopeInfo::setHasSEHTry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 365,
   FQN="clang::sema::FunctionScopeInfo::setHasSEHTry", NM="_ZN5clang4sema17FunctionScopeInfo12setHasSEHTryENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema17FunctionScopeInfo12setHasSEHTryENS_14SourceLocationE")
  //</editor-fold>
  public void setHasSEHTry(SourceLocation TryLoc) {
    setHasBranchProtectedScope();
    FirstSEHTryLoc.$assign(TryLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::FunctionScopeInfo::NeedsScopeChecking">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 370,
   FQN="clang::sema::FunctionScopeInfo::NeedsScopeChecking", NM="_ZNK5clang4sema17FunctionScopeInfo18NeedsScopeCheckingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZNK5clang4sema17FunctionScopeInfo18NeedsScopeCheckingEv")
  //</editor-fold>
  public boolean NeedsScopeChecking() /*const*/ {
    return !HasDroppedStmt
       && (HasIndirectGoto
       || (HasBranchProtectedScope && HasBranchIntoScope));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::FunctionScopeInfo::FunctionScopeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 376,
   FQN="clang::sema::FunctionScopeInfo::FunctionScopeInfo", NM="_ZN5clang4sema17FunctionScopeInfoC1ERNS_17DiagnosticsEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema17FunctionScopeInfoC1ERNS_17DiagnosticsEngineE")
  //</editor-fold>
  public FunctionScopeInfo(final DiagnosticsEngine /*&*/ Diag) {
    // : Kind(SK_Function), HasBranchProtectedScope(false), HasBranchIntoScope(false), HasIndirectGoto(false), HasDroppedStmt(false), HasOMPDeclareReductionCombiner(false), HasFallthroughStmt(false), ObjCShouldCallSuper(false), ObjCIsDesignatedInit(false), ObjCWarnForNoDesignatedInitChain(false), ObjCIsSecondaryInit(false), ObjCWarnForNoInitDelegation(false), FirstReturnLoc(), FirstCXXTryLoc(), FirstSEHTryLoc(), ErrorTrap(Diag), SwitchStack(), Returns(), CoroutineStmts(), CompoundScopes(), PossiblyUnreachableDiags(), ModifiedNonNullParams(), WeakObjectUses() 
    //START JInit
    this.Kind = ScopeKind.SK_Function;
    this.HasBranchProtectedScope = false;
    this.HasBranchIntoScope = false;
    this.HasIndirectGoto = false;
    this.HasDroppedStmt = false;
    this.HasOMPDeclareReductionCombiner = false;
    this.HasFallthroughStmt = false;
    this.ObjCShouldCallSuper = false;
    this.ObjCIsDesignatedInit = false;
    this.ObjCWarnForNoDesignatedInitChain = false;
    this.ObjCIsSecondaryInit = false;
    this.ObjCWarnForNoInitDelegation = false;
    this.FirstReturnLoc = new SourceLocation();
    this.FirstCXXTryLoc = new SourceLocation();
    this.FirstSEHTryLoc = new SourceLocation();
    this.ErrorTrap = new DiagnosticErrorTrap(Diag);
    this.SwitchStack = new SmallVector<SwitchStmt /*P*/ >(8, (SwitchStmt /*P*/ )null);
    this.Returns = new SmallVector<ReturnStmt /*P*/ >(4, (ReturnStmt /*P*/ )null);
    this.CoroutineStmts = new SmallVector<Stmt /*P*/ >(4, (Stmt /*P*/ )null);
    this.CompoundScopes = new SmallVector<CompoundScopeInfo>(4, new CompoundScopeInfo());
    this.PossiblyUnreachableDiags = new SmallVector<PossiblyUnreachableDiag>(4, new PossiblyUnreachableDiag());
    this.ModifiedNonNullParams = new SmallPtrSet</*const*/ ParmVarDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 8);
    this.WeakObjectUses = new SmallDenseMap<WeakObjectProfileTy, SmallVector<WeakUseTy>>(FunctionScopeInfo.WeakObjectProfileTy.DenseMapInfo.$Info(), new SmallVector<WeakUseTy>(4, new WeakUseTy()));
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::FunctionScopeInfo::~FunctionScopeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp", line = 241,
   FQN="clang::sema::FunctionScopeInfo::~FunctionScopeInfo", NM="_ZN5clang4sema17FunctionScopeInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema17FunctionScopeInfoD0Ev")
  //</editor-fold>
  public void $destroy() {
    //START JDestroy
    WeakObjectUses.$destroy();
    ModifiedNonNullParams.$destroy();
    PossiblyUnreachableDiags.$destroy();
    CompoundScopes.$destroy();
    CoroutineStmts.$destroy();
    Returns.$destroy();
    SwitchStack.$destroy();
    //END JDestroy
  }

  
  /// \brief Clear out the information in this function scope, making it
  /// suitable for reuse.
  //<editor-fold defaultstate="collapsed" desc="clang::sema::FunctionScopeInfo::Clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp", line = 26,
   FQN="clang::sema::FunctionScopeInfo::Clear", NM="_ZN5clang4sema17FunctionScopeInfo5ClearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/ScopeInfo.cpp -nm=_ZN5clang4sema17FunctionScopeInfo5ClearEv")
  //</editor-fold>
  public void Clear() {
    HasBranchProtectedScope = false;
    HasBranchIntoScope = false;
    HasIndirectGoto = false;
    HasDroppedStmt = false;
    HasOMPDeclareReductionCombiner = false;
    ObjCShouldCallSuper = false;
    ObjCIsDesignatedInit = false;
    ObjCWarnForNoDesignatedInitChain = false;
    ObjCIsSecondaryInit = false;
    ObjCWarnForNoInitDelegation = false;
    FirstReturnLoc.$assignMove(new SourceLocation());
    FirstCXXTryLoc.$assignMove(new SourceLocation());
    FirstSEHTryLoc.$assignMove(new SourceLocation());
    
    SwitchStack.clear();
    Returns.clear();
    CoroutinePromise = null;
    CoroutineStmts.clear();
    ErrorTrap.reset();
    PossiblyUnreachableDiags.clear();
    WeakObjectUses.clear();
    ModifiedNonNullParams.clear();
  }

  
  @Override public String toString() {
    return "" + "Kind=" + Kind // NOI18N
              + ", HasBranchProtectedScope=" + HasBranchProtectedScope // NOI18N
              + ", HasBranchIntoScope=" + HasBranchIntoScope // NOI18N
              + ", HasIndirectGoto=" + HasIndirectGoto // NOI18N
              + ", HasDroppedStmt=" + HasDroppedStmt // NOI18N
              + ", HasOMPDeclareReductionCombiner=" + HasOMPDeclareReductionCombiner // NOI18N
              + ", HasFallthroughStmt=" + HasFallthroughStmt // NOI18N
              + ", ObjCShouldCallSuper=" + ObjCShouldCallSuper // NOI18N
              + ", ObjCIsDesignatedInit=" + ObjCIsDesignatedInit // NOI18N
              + ", ObjCWarnForNoDesignatedInitChain=" + ObjCWarnForNoDesignatedInitChain // NOI18N
              + ", ObjCIsSecondaryInit=" + ObjCIsSecondaryInit // NOI18N
              + ", ObjCWarnForNoInitDelegation=" + ObjCWarnForNoInitDelegation // NOI18N
              + ", FirstReturnLoc=" + FirstReturnLoc // NOI18N
              + ", FirstCXXTryLoc=" + FirstCXXTryLoc // NOI18N
              + ", FirstSEHTryLoc=" + FirstSEHTryLoc // NOI18N
              + ", ErrorTrap=" + ErrorTrap // NOI18N
              + ", SwitchStack=" + SwitchStack // NOI18N
              + ", Returns=" + Returns // NOI18N
              + ", CoroutinePromise=" + CoroutinePromise // NOI18N
              + ", CoroutineStmts=" + CoroutineStmts // NOI18N
              + ", CompoundScopes=" + CompoundScopes // NOI18N
              + ", PossiblyUnreachableDiags=" + PossiblyUnreachableDiags // NOI18N
              + ", ModifiedNonNullParams=" + ModifiedNonNullParams // NOI18N
              + ", WeakObjectUses=" + WeakObjectUses; // NOI18N
  }
}
