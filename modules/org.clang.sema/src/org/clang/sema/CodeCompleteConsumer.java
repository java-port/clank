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

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.clangc.*;
import static org.clang.sema.impl.SemaCodeCompleteStatics.*;
import static org.clang.ast.java.AstTypesRTTI.*;


/// \brief Abstract interface for a consumer of code-completion
/// information.
//<editor-fold defaultstate="collapsed" desc="clang::CodeCompleteConsumer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 808,
 FQN="clang::CodeCompleteConsumer", NM="_ZN5clang20CodeCompleteConsumerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang20CodeCompleteConsumerE")
//</editor-fold>
public abstract class CodeCompleteConsumer implements Destructors.ClassWithDestructor {
/*protected:*/
  protected /*const*/ CodeCompleteOptions CodeCompleteOpts;
  
  /// \brief Whether the output format for the code-completion consumer is
  /// binary.
  protected boolean OutputIsBinary;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompleteConsumer::OverloadCandidate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 817,
   FQN="clang::CodeCompleteConsumer::OverloadCandidate", NM="_ZN5clang20CodeCompleteConsumer17OverloadCandidateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang20CodeCompleteConsumer17OverloadCandidateE")
  //</editor-fold>
  public static class OverloadCandidate implements NativeCloneable<OverloadCandidate> {
  /*public:*/
    /// \brief Describes the type of overload candidate.
    //<editor-fold defaultstate="collapsed" desc="clang::CodeCompleteConsumer::OverloadCandidate::CandidateKind">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 820,
     FQN="clang::CodeCompleteConsumer::OverloadCandidate::CandidateKind", NM="_ZN5clang20CodeCompleteConsumer17OverloadCandidate13CandidateKindE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang20CodeCompleteConsumer17OverloadCandidate13CandidateKindE")
    //</editor-fold>
    public enum CandidateKind implements Native.ComparableLower {
      /// \brief The candidate is a function declaration.
      CK_Function(0),
      /// \brief The candidate is a function template.
      CK_FunctionTemplate(CK_Function.getValue() + 1),
      /// \brief The "candidate" is actually a variable, expression, or block
      /// for which we only have a function prototype.
      CK_FunctionType(CK_FunctionTemplate.getValue() + 1);

      //<editor-fold defaultstate="collapsed" desc="hidden">
      public static CandidateKind valueOf(int val) {
        CandidateKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
        assert out != null : "no value for " + val;
        assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
        return out;
      }

      private static final class Values {
        private static final CandidateKind[] VALUES;
        private static final CandidateKind[] _VALUES; // [0] not used
        static {
          int max = 0;
          int min = 0;
          for (CandidateKind kind : CandidateKind.values()) {
            if (kind.value > max) { max = kind.value; }
            if (kind.value < min) { min = kind.value; }
          }
          _VALUES = new CandidateKind[min < 0 ? (1-min) : 0];
          VALUES = new CandidateKind[max >= 0 ? (1+max) : 0];
          for (CandidateKind kind : CandidateKind.values()) {
            if (kind.value < 0) {
              _VALUES[-kind.value] = kind;
            } else {
              VALUES[kind.value] = kind;
            }
          }
        }
      }

      private final /*uint*/int value;
      private CandidateKind(int val) { this.value = (/*uint*/int)val;}
      public /*uint*/int getValue() { return value;}
      @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((CandidateKind)obj).value);}
      @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((CandidateKind)obj).value);}
      //</editor-fold>
    };
  /*private:*/
    /// \brief The kind of overload candidate.
    private CandidateKind Kind;
    //<editor-fold defaultstate="collapsed" desc="clang::CodeCompleteConsumer::OverloadCandidate::(anonymous)">
    @Converted(kind = Converted.Kind.MANUAL,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 834,
     FQN="clang::CodeCompleteConsumer::OverloadCandidate::(anonymous)", NM="_ZN5clang20CodeCompleteConsumer17OverloadCandidateE_Unnamed_union1",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang20CodeCompleteConsumer17OverloadCandidateE_Unnamed_union1")
    //</editor-fold>
    private static class/*union*/ Unnamed_union1 {
      /// \brief The function overload candidate, available when
      /// Kind == CK_Function.
      public FunctionDecl /*P*/ Function;
      
      /// \brief The function template overload candidate, available when
      /// Kind == CK_FunctionTemplate.
      public FunctionTemplateDecl /*P*/ FunctionTemplate;
      
      /// \brief The function type that describes the entity being called,
      /// when Kind == CK_FunctionType.
      public /*const*/ FunctionType /*P*/ Type;

      public Unnamed_union1() {
      }

      public Unnamed_union1(Unnamed_union1 $Prm0) {
        this.Function = $Prm0.Function;
        this.FunctionTemplate = $Prm0.FunctionTemplate;
        this.Type = $Prm0.Type;
      }
      
      @Override public String toString() {
        return "" + "Function=" + Function // NOI18N
                  + ", FunctionTemplate=" + FunctionTemplate // NOI18N
                  + ", Type=" + Type; // NOI18N
      }
    };
    private Unnamed_union1 Unnamed_field1 = new Unnamed_union1();

  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::CodeCompleteConsumer::OverloadCandidate::OverloadCandidate">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 849,
     FQN="clang::CodeCompleteConsumer::OverloadCandidate::OverloadCandidate", NM="_ZN5clang20CodeCompleteConsumer17OverloadCandidateC1EPNS_12FunctionDeclE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang20CodeCompleteConsumer17OverloadCandidateC1EPNS_12FunctionDeclE")
    //</editor-fold>
    public OverloadCandidate(FunctionDecl /*P*/ Function) {
      // : Kind(CK_Function), Function(Function) 
      //START JInit
      this.Kind = CandidateKind.CK_Function;
      /*Indirect*/this.Unnamed_field1.Function = Function;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::CodeCompleteConsumer::OverloadCandidate::OverloadCandidate">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 852,
     FQN="clang::CodeCompleteConsumer::OverloadCandidate::OverloadCandidate", NM="_ZN5clang20CodeCompleteConsumer17OverloadCandidateC1EPNS_20FunctionTemplateDeclE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang20CodeCompleteConsumer17OverloadCandidateC1EPNS_20FunctionTemplateDeclE")
    //</editor-fold>
    public OverloadCandidate(FunctionTemplateDecl /*P*/ FunctionTemplateDecl) {
      // : Kind(CK_FunctionTemplate), FunctionTemplate(FunctionTemplateDecl) 
      //START JInit
      this.Kind = CandidateKind.CK_FunctionTemplate;
      /*Indirect*/this.Unnamed_field1.FunctionTemplate = FunctionTemplateDecl;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::CodeCompleteConsumer::OverloadCandidate::OverloadCandidate">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 855,
     FQN="clang::CodeCompleteConsumer::OverloadCandidate::OverloadCandidate", NM="_ZN5clang20CodeCompleteConsumer17OverloadCandidateC1EPKNS_12FunctionTypeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang20CodeCompleteConsumer17OverloadCandidateC1EPKNS_12FunctionTypeE")
    //</editor-fold>
    public OverloadCandidate(/*const*/ FunctionType /*P*/ Type) {
      // : Kind(CK_FunctionType), Type(Type) 
      //START JInit
      this.Kind = CandidateKind.CK_FunctionType;
      /*Indirect*/this.Unnamed_field1.Type = Type;
      //END JInit
    }

    
    /// \brief Determine the kind of overload candidate.
    //<editor-fold defaultstate="collapsed" desc="clang::CodeCompleteConsumer::OverloadCandidate::getKind">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 859,
     FQN="clang::CodeCompleteConsumer::OverloadCandidate::getKind", NM="_ZNK5clang20CodeCompleteConsumer17OverloadCandidate7getKindEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZNK5clang20CodeCompleteConsumer17OverloadCandidate7getKindEv")
    //</editor-fold>
    public CandidateKind getKind() /*const*/ {
      return Kind;
    }

    
    /// \brief Retrieve the function overload candidate or the templated
    /// function declaration for a function template.
    
    //===----------------------------------------------------------------------===//
    // Code completion overload candidate implementation
    //===----------------------------------------------------------------------===//
    //<editor-fold defaultstate="collapsed" desc="clang::CodeCompleteConsumer::OverloadCandidate::getFunction">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp", line = 398,
     FQN="clang::CodeCompleteConsumer::OverloadCandidate::getFunction", NM="_ZNK5clang20CodeCompleteConsumer17OverloadCandidate11getFunctionEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZNK5clang20CodeCompleteConsumer17OverloadCandidate11getFunctionEv")
    //</editor-fold>
    public FunctionDecl /*P*/ getFunction() /*const*/ {
      if (getKind() == CandidateKind.CK_Function) {
        return Unnamed_field1.Function;
      } else if (getKind() == CandidateKind.CK_FunctionTemplate) {
        return Unnamed_field1.FunctionTemplate.getTemplatedDecl();
      } else {
        return null;
      }
    }

    
    /// \brief Retrieve the function template overload candidate.
    //<editor-fold defaultstate="collapsed" desc="clang::CodeCompleteConsumer::OverloadCandidate::getFunctionTemplate">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 866,
     FQN="clang::CodeCompleteConsumer::OverloadCandidate::getFunctionTemplate", NM="_ZNK5clang20CodeCompleteConsumer17OverloadCandidate19getFunctionTemplateEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZNK5clang20CodeCompleteConsumer17OverloadCandidate19getFunctionTemplateEv")
    //</editor-fold>
    public FunctionTemplateDecl /*P*/ getFunctionTemplate() /*const*/ {
      assert (getKind() == CandidateKind.CK_FunctionTemplate) : "Not a function template";
      return Unnamed_field1.FunctionTemplate;
    }

    
    /// \brief Retrieve the function type of the entity, regardless of how the
    /// function is stored.
    //<editor-fold defaultstate="collapsed" desc="clang::CodeCompleteConsumer::OverloadCandidate::getFunctionType">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp", line = 408,
     FQN="clang::CodeCompleteConsumer::OverloadCandidate::getFunctionType", NM="_ZNK5clang20CodeCompleteConsumer17OverloadCandidate15getFunctionTypeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZNK5clang20CodeCompleteConsumer17OverloadCandidate15getFunctionTypeEv")
    //</editor-fold>
    public /*const*/ FunctionType /*P*/ getFunctionType() /*const*/ {
      switch (Kind) {
       case CK_Function:
        return Unnamed_field1.Function.getType().$arrow().getAs(FunctionType.class);
       case CK_FunctionTemplate:
        return Unnamed_field1.FunctionTemplate.getTemplatedDecl().getType().$arrow().getAs(FunctionType.class);
       case CK_FunctionType:
        return Unnamed_field1.Type;
      }
      throw new llvm_unreachable("Invalid CandidateKind!");
    }

    
    /// \brief Create a new code-completion string that describes the function
    /// signature of this overload candidate.
    
    /// \brief Create a new code-completion string that describes the function
    /// signature of this overload candidate.
    //<editor-fold defaultstate="collapsed" desc="clang::CodeCompleteConsumer::OverloadCandidate::CreateSignatureString">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 2952,
     FQN="clang::CodeCompleteConsumer::OverloadCandidate::CreateSignatureString", NM="_ZNK5clang20CodeCompleteConsumer17OverloadCandidate21CreateSignatureStringEjRNS_4SemaERNS_23CodeCompletionAllocatorERNS_20CodeCompletionTUInfoEb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZNK5clang20CodeCompleteConsumer17OverloadCandidate21CreateSignatureStringEjRNS_4SemaERNS_23CodeCompletionAllocatorERNS_20CodeCompletionTUInfoEb")
    //</editor-fold>
    public CodeCompletionString /*P*/ CreateSignatureString(/*uint*/int CurrentArg, final Sema /*&*/ S, 
                         final CodeCompletionAllocator /*&*/ Allocator, 
                         final CodeCompletionTUInfo /*&*/ CCTUInfo, 
                         boolean IncludeBriefComments) /*const*/ {
      CodeCompletionBuilder Result = null;
      try {
        PrintingPolicy Policy = getCompletionPrintingPolicy(S);
        
        // FIXME: Set priority, availability appropriately.
        Result/*J*/= new CodeCompletionBuilder(Allocator, CCTUInfo, 1, CXAvailabilityKind.CXAvailability_Available);
        FunctionDecl /*P*/ FDecl = getFunction();
        /*const*/ FunctionProtoType /*P*/ Proto = dyn_cast_FunctionProtoType(getFunctionType());
        if (!(FDecl != null) && !(Proto != null)) {
          // Function without a prototype. Just give the return type and a 
          // highlighted ellipsis.
          /*const*/ FunctionType /*P*/ FT = getFunctionType();
          Result.AddResultTypeChunk(Result.getAllocator().CopyString(new Twine(FT.getReturnType().getAsString(Policy))));
          Result.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
          Result.AddChunk(CodeCompletionString.ChunkKind.CK_CurrentParameter, $ELLIPSIS);
          Result.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
          return Result.TakeString();
        }
        if ((FDecl != null)) {
          if (IncludeBriefComments && $less_uint(CurrentArg, FDecl.getNumParams())) {
            {
              /*const*/ RawComment /*P*/ RC = S.getASTContext().getRawCommentForAnyRedecl(FDecl.getParamDecl(CurrentArg));
              if ((RC != null)) {
                Result.addBriefComment(new StringRef(RC.getBriefText(S.getASTContext())));
              }
            }
          }
          AddResultTypeChunk(S.Context, Policy, FDecl, new QualType(), Result);
          Result.AddTextChunk(Result.getAllocator().CopyString(new Twine(FDecl.getNameAsString())));
        } else {
          Result.AddResultTypeChunk(Result.getAllocator().CopyString(new Twine(Proto.getReturnType().getAsString(Policy))));
        }
        
        Result.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
        AddOverloadParameterChunks(S.getASTContext(), Policy, FDecl, Proto, Result, 
            CurrentArg);
        Result.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
        
        return Result.TakeString();
      } finally {
        if (Result != null) { Result.$destroy(); }
      }
    }



    //<editor-fold defaultstate="collapsed" desc="clang::CodeCompleteConsumer::OverloadCandidate::~OverloadCandidate">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 817,
     FQN="clang::CodeCompleteConsumer::OverloadCandidate::~OverloadCandidate", NM="_ZN5clang20CodeCompleteConsumer17OverloadCandidateD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang20CodeCompleteConsumer17OverloadCandidateD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
    }

    public OverloadCandidate() {
      this.Kind = CandidateKind.CK_Function; // == 0
    }
    
    private OverloadCandidate(OverloadCandidate $Prm0) {
      this.Kind = $Prm0.Kind;
      this.Unnamed_field1 = new Unnamed_union1($Prm0.Unnamed_field1);
    }
    
    @Override public OverloadCandidate clone() {
      return new OverloadCandidate(this);
    }
    
    @Override public String toString() {
      return "" + "Kind=" + Kind // NOI18N
                + ", Unnamed_field1=" + Unnamed_field1; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompleteConsumer::CodeCompleteConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 884,
   FQN="clang::CodeCompleteConsumer::CodeCompleteConsumer", NM="_ZN5clang20CodeCompleteConsumerC1ERKNS_19CodeCompleteOptionsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang20CodeCompleteConsumerC1ERKNS_19CodeCompleteOptionsEb")
  //</editor-fold>
  public CodeCompleteConsumer(final /*const*/ CodeCompleteOptions /*&*/ CodeCompleteOpts, 
      boolean OutputIsBinary) {
    // : CodeCompleteOpts(CodeCompleteOpts), OutputIsBinary(OutputIsBinary) 
    //START JInit
    this.CodeCompleteOpts = new CodeCompleteOptions(CodeCompleteOpts);
    this.OutputIsBinary = OutputIsBinary;
    //END JInit
  }

  
  /// \brief Whether the code-completion consumer wants to see macros.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompleteConsumer::includeMacros">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 890,
   FQN="clang::CodeCompleteConsumer::includeMacros", NM="_ZNK5clang20CodeCompleteConsumer13includeMacrosEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZNK5clang20CodeCompleteConsumer13includeMacrosEv")
  //</editor-fold>
  public boolean includeMacros() /*const*/ {
    return CodeCompleteOpts.IncludeMacros;
  }

  
  /// \brief Whether the code-completion consumer wants to see code patterns.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompleteConsumer::includeCodePatterns">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 895,
   FQN="clang::CodeCompleteConsumer::includeCodePatterns", NM="_ZNK5clang20CodeCompleteConsumer19includeCodePatternsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZNK5clang20CodeCompleteConsumer19includeCodePatternsEv")
  //</editor-fold>
  public boolean includeCodePatterns() /*const*/ {
    return CodeCompleteOpts.IncludeCodePatterns;
  }

  
  /// \brief Whether to include global (top-level) declaration results.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompleteConsumer::includeGlobals">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 900,
   FQN="clang::CodeCompleteConsumer::includeGlobals", NM="_ZNK5clang20CodeCompleteConsumer14includeGlobalsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZNK5clang20CodeCompleteConsumer14includeGlobalsEv")
  //</editor-fold>
  public boolean includeGlobals() /*const*/ {
    return CodeCompleteOpts.IncludeGlobals;
  }

  
  /// \brief Whether to include brief documentation comments within the set of
  /// code completions returned.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompleteConsumer::includeBriefComments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 906,
   FQN="clang::CodeCompleteConsumer::includeBriefComments", NM="_ZNK5clang20CodeCompleteConsumer20includeBriefCommentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZNK5clang20CodeCompleteConsumer20includeBriefCommentsEv")
  //</editor-fold>
  public boolean includeBriefComments() /*const*/ {
    return CodeCompleteOpts.IncludeBriefComments;
  }

  
  /// \brief Determine whether the output of this consumer is binary.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompleteConsumer::isOutputBinary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 911,
   FQN="clang::CodeCompleteConsumer::isOutputBinary", NM="_ZNK5clang20CodeCompleteConsumer14isOutputBinaryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZNK5clang20CodeCompleteConsumer14isOutputBinaryEv")
  //</editor-fold>
  public boolean isOutputBinary() /*const*/ {
    return OutputIsBinary;
  }

  
  /// \brief Deregisters and destroys this code-completion consumer.
  
  //===----------------------------------------------------------------------===//
  // Code completion consumer implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompleteConsumer::~CodeCompleteConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp", line = 429,
   FQN="clang::CodeCompleteConsumer::~CodeCompleteConsumer", NM="_ZN5clang20CodeCompleteConsumerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang20CodeCompleteConsumerD0Ev")
  //</editor-fold>
  public void $destroy() {
  }

  
  /// \name Code-completion callbacks
  //@{
  /// \brief Process the finalized code-completion results.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompleteConsumer::ProcessCodeCompleteResults">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 919,
   FQN="clang::CodeCompleteConsumer::ProcessCodeCompleteResults", NM="_ZN5clang20CodeCompleteConsumer26ProcessCodeCompleteResultsERNS_4SemaENS_21CodeCompletionContextEPNS_20CodeCompletionResultEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang20CodeCompleteConsumer26ProcessCodeCompleteResultsERNS_4SemaENS_21CodeCompletionContextEPNS_20CodeCompletionResultEj")
  //</editor-fold>
  public /*virtual*/ void ProcessCodeCompleteResults(final Sema /*&*/ S, 
                            CodeCompletionContext Context, 
                            type$ptr<CodeCompletionResult/*P*/> Results, 
                            /*uint*/int NumResults) {
  }

  
  /// \param S the semantic-analyzer object for which code-completion is being
  /// done.
  ///
  /// \param CurrentArg the index of the current argument.
  ///
  /// \param Candidates an array of overload candidates.
  ///
  /// \param NumCandidates the number of overload candidates
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompleteConsumer::ProcessOverloadCandidates">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 932,
   FQN="clang::CodeCompleteConsumer::ProcessOverloadCandidates", NM="_ZN5clang20CodeCompleteConsumer25ProcessOverloadCandidatesERNS_4SemaEjPNS0_17OverloadCandidateEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang20CodeCompleteConsumer25ProcessOverloadCandidatesERNS_4SemaEjPNS0_17OverloadCandidateEj")
  //</editor-fold>
  public /*virtual*/ void ProcessOverloadCandidates(final Sema /*&*/ S, /*uint*/int CurrentArg, 
                           type$ptr<OverloadCandidate> /*P*/ Candidates, 
                           /*uint*/int NumCandidates) {
  }

  //@}
  
  /// \brief Retrieve the allocator that will be used to allocate
  /// code completion strings.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompleteConsumer::getAllocator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 939,
   FQN="clang::CodeCompleteConsumer::getAllocator", NM="_ZN5clang20CodeCompleteConsumer12getAllocatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang20CodeCompleteConsumer12getAllocatorEv")
  //</editor-fold>
  public abstract /*virtual*/ CodeCompletionAllocator /*&*/ getAllocator()/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompleteConsumer::getCodeCompletionTUInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 941,
   FQN="clang::CodeCompleteConsumer::getCodeCompletionTUInfo", NM="_ZN5clang20CodeCompleteConsumer23getCodeCompletionTUInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang20CodeCompleteConsumer23getCodeCompletionTUInfoEv")
  //</editor-fold>
  public abstract /*virtual*/ CodeCompletionTUInfo /*&*/ getCodeCompletionTUInfo()/* = 0*/;

  
  @Override public String toString() {
    return "" + "CodeCompleteOpts=" + CodeCompleteOpts // NOI18N
              + ", OutputIsBinary=" + OutputIsBinary; // NOI18N
  }
}
