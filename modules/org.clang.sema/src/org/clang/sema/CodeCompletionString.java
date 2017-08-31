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

import java.util.Iterator;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.clangc.*;


/// \brief A "string" used to describe how code completion can
/// be performed for an entity.
///
/// A code completion string typically shows how a particular entity can be
/// used. For example, the code completion string for a function would show
/// the syntax to call it, including the parentheses, placeholders for the
/// arguments, etc.
//<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 324,
 FQN="clang::CodeCompletionString", NM="_ZN5clang20CodeCompletionStringE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang20CodeCompletionStringE")
//</editor-fold>
public class CodeCompletionString implements Iterable<CodeCompletionString.Chunk>, Destructors.ClassWithDestructor {

/*public:*/
  /// \brief The different kinds of "chunks" that can occur within a code
  /// completion string.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionString::ChunkKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 328,
   FQN="clang::CodeCompletionString::ChunkKind", NM="_ZN5clang20CodeCompletionString9ChunkKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang20CodeCompletionString9ChunkKindE")
  //</editor-fold>
  public enum ChunkKind implements Native.ComparableLower {
    /// \brief The piece of text that the user is expected to type to
    /// match the code-completion string, typically a keyword or the name of a
    /// declarator or macro.
    CK_TypedText(0),
    /// \brief A piece of text that should be placed in the buffer, e.g.,
    /// parentheses or a comma in a function call.
    CK_Text(CK_TypedText.getValue() + 1),
    /// \brief A code completion string that is entirely optional. For example,
    /// an optional code completion string that describes the default arguments
    /// in a function call.
    CK_Optional(CK_Text.getValue() + 1),
    /// \brief A string that acts as a placeholder for, e.g., a function
    /// call argument.
    CK_Placeholder(CK_Optional.getValue() + 1),
    /// \brief A piece of text that describes something about the result but
    /// should not be inserted into the buffer.
    CK_Informative(CK_Placeholder.getValue() + 1),
    /// \brief A piece of text that describes the type of an entity or, for
    /// functions and methods, the return type.
    CK_ResultType(CK_Informative.getValue() + 1),
    /// \brief A piece of text that describes the parameter that corresponds
    /// to the code-completion location within a function call, message send,
    /// macro invocation, etc.
    CK_CurrentParameter(CK_ResultType.getValue() + 1),
    /// \brief A left parenthesis ('(').
    CK_LeftParen(CK_CurrentParameter.getValue() + 1),
    /// \brief A right parenthesis (')').
    CK_RightParen(CK_LeftParen.getValue() + 1),
    /// \brief A left bracket ('[').
    CK_LeftBracket(CK_RightParen.getValue() + 1),
    /// \brief A right bracket (']').
    CK_RightBracket(CK_LeftBracket.getValue() + 1),
    /// \brief A left brace ('{').
    CK_LeftBrace(CK_RightBracket.getValue() + 1),
    /// \brief A right brace ('}').
    CK_RightBrace(CK_LeftBrace.getValue() + 1),
    /// \brief A left angle bracket ('<').
    CK_LeftAngle(CK_RightBrace.getValue() + 1),
    /// \brief A right angle bracket ('>').
    CK_RightAngle(CK_LeftAngle.getValue() + 1),
    /// \brief A comma separator (',').
    CK_Comma(CK_RightAngle.getValue() + 1),
    /// \brief A colon (':').
    CK_Colon(CK_Comma.getValue() + 1),
    /// \brief A semicolon (';').
    CK_SemiColon(CK_Colon.getValue() + 1),
    /// \brief An '=' sign.
    CK_Equal(CK_SemiColon.getValue() + 1),
    /// \brief Horizontal whitespace (' ').
    CK_HorizontalSpace(CK_Equal.getValue() + 1),
    /// \brief Vertical whitespace ('\\n' or '\\r\\n', depending on the
    /// platform).
    CK_VerticalSpace(CK_HorizontalSpace.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ChunkKind valueOf(int val) {
      ChunkKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final ChunkKind[] VALUES;
      private static final ChunkKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ChunkKind kind : ChunkKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ChunkKind[min < 0 ? (1-min) : 0];
        VALUES = new ChunkKind[max >= 0 ? (1+max) : 0];
        for (ChunkKind kind : ChunkKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private ChunkKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((ChunkKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((ChunkKind)obj).value);}
    //</editor-fold>
  };
  
  /// \brief One piece of the code completion string.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionString::Chunk">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 385,
   FQN="clang::CodeCompletionString::Chunk", NM="_ZN5clang20CodeCompletionString5ChunkE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang20CodeCompletionString5ChunkE")
  //</editor-fold>
  public static class/*struct*/ Chunk implements NativePOD<Chunk> {
    /// \brief The kind of data stored in this piece of the code completion
    /// string.
    public ChunkKind Kind;
    //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionString::Chunk::(anonymous)">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 390,
     FQN="clang::CodeCompletionString::Chunk::(anonymous)", NM="_ZN5clang20CodeCompletionString5ChunkE_Unnamed_union1",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang20CodeCompletionString5ChunkE_Unnamed_union1")
    //</editor-fold>
    public static class/*union*/ Unnamed_union1 {
      /// \brief The text string associated with a CK_Text, CK_Placeholder,
      /// CK_Informative, or CK_Comma chunk.
      /// The string is owned by the chunk and will be deallocated
      /// (with delete[]) when the chunk is destroyed.
      public /*const*/char$ptr/*char P*/ Text;
      
      /// \brief The code completion string associated with a CK_Optional chunk.
      /// The optional code completion string is owned by the chunk, and will
      /// be deallocated (with delete) when the chunk is destroyed.
      public CodeCompletionString /*P*/ Optional;
      
      //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionString::Chunk::(anonymous union)::">
      @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*assign fields*/,
       source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 390,
       FQN="clang::CodeCompletionString::Chunk::(anonymous union)::", NM="_ZN5clang20CodeCompletionString5ChunkUt_C1EOS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang20CodeCompletionString5ChunkUt_C1EOS2_")
      //</editor-fold>
      public /*inline*/ Unnamed_union1(JD$Move _dparam, final Unnamed_union1 $Prm0) {
        $assign($Prm0);
      }

      //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionString::Chunk::(anonymous union)::operator=">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 390,
       FQN="clang::CodeCompletionString::Chunk::(anonymous union)::operator=", NM="_ZN5clang20CodeCompletionString5ChunkUt_aSERKS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang20CodeCompletionString5ChunkUt_aSERKS2_")
      //</editor-fold>
      public /*inline*/ Unnamed_union1 $assign(final Unnamed_union1 $Prm0) {
        
        this.Text = $tryClone($Prm0.Text);
        
        this.Optional = $Prm0.Optional;
        
        return /*Deref*/this;
      }

      private Unnamed_union1() { }
      
      @Override public String toString() {
        return "" + "Text=" + Text // NOI18N
                  + ", Optional=" + Optional; // NOI18N
      }
    };
    public Unnamed_union1 Unnamed_field1 = new Unnamed_union1();
    
    //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionString::Chunk::Chunk">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 403,
     FQN="clang::CodeCompletionString::Chunk::Chunk", NM="_ZN5clang20CodeCompletionString5ChunkC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang20CodeCompletionString5ChunkC1Ev")
    //</editor-fold>
    public Chunk() {
      // : Kind(CK_Text), Text(null) 
      //START JInit
      this.Kind = ChunkKind.CK_Text;
      /*Indirect*/this.Unnamed_field1.Text = null;
      //END JInit
    }

    
    
    //===----------------------------------------------------------------------===//
    // Code completion string implementation
    //===----------------------------------------------------------------------===//
    //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionString::Chunk::Chunk">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp", line = 81,
     FQN="clang::CodeCompletionString::Chunk::Chunk", NM="_ZN5clang20CodeCompletionString5ChunkC1ENS0_9ChunkKindEPKc",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang20CodeCompletionString5ChunkC1ENS0_9ChunkKindEPKc")
    //</editor-fold>
    public Chunk(ChunkKind Kind) {
      this(Kind, $EMPTY);
    }
    public Chunk(ChunkKind Kind, /*const*/char$ptr/*char P*/ Text/*= ""*/) {
      // : Kind(Kind), Text("") 
      //START JInit
      this.Kind = Kind;
      /*Indirect*/this.Unnamed_field1.Text = $tryClone($EMPTY);
      //END JInit
      switch (Kind) {
       case CK_TypedText:
       case CK_Text:
       case CK_Placeholder:
       case CK_Informative:
       case CK_ResultType:
       case CK_CurrentParameter:
        this.Unnamed_field1.Text = $tryClone(Text);
        break;
       case CK_Optional:
        throw new llvm_unreachable("Optional strings cannot be created from text");
       case CK_LeftParen:
        this.Unnamed_field1.Text = $tryClone($LPAREN);
        break;
       case CK_RightParen:
        this.Unnamed_field1.Text = $tryClone($RPAREN);
        break;
       case CK_LeftBracket:
        this.Unnamed_field1.Text = $tryClone($LSQUARE);
        break;
       case CK_RightBracket:
        this.Unnamed_field1.Text = $tryClone($RSQUARE);
        break;
       case CK_LeftBrace:
        this.Unnamed_field1.Text = $tryClone($LCURLY);
        break;
       case CK_RightBrace:
        this.Unnamed_field1.Text = $tryClone($RCURLY);
        break;
       case CK_LeftAngle:
        this.Unnamed_field1.Text = $tryClone($LT);
        break;
       case CK_RightAngle:
        this.Unnamed_field1.Text = $tryClone($GT);
        break;
       case CK_Comma:
        this.Unnamed_field1.Text = $tryClone($COMMA_SPACE);
        break;
       case CK_Colon:
        this.Unnamed_field1.Text = $tryClone($COLON);
        break;
       case CK_SemiColon:
        this.Unnamed_field1.Text = $tryClone($SEMI);
        break;
       case CK_Equal:
        this.Unnamed_field1.Text = $tryClone($(" = "));
        break;
       case CK_HorizontalSpace:
        this.Unnamed_field1.Text = $tryClone($SPACE);
        break;
       case CK_VerticalSpace:
        this.Unnamed_field1.Text = $tryClone($LF);
        break;
      }
    }

    
    /// \brief Create a new text chunk.
    //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionString::Chunk::CreateText">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp", line = 155,
     FQN="clang::CodeCompletionString::Chunk::CreateText", NM="_ZN5clang20CodeCompletionString5Chunk10CreateTextEPKc",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang20CodeCompletionString5Chunk10CreateTextEPKc")
    //</editor-fold>
    public static CodeCompletionString.Chunk CreateText(/*const*/char$ptr/*char P*/ Text) {
      return new Chunk(ChunkKind.CK_Text, Text);
    }

    
    /// \brief Create a new optional chunk.
    //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionString::Chunk::CreateOptional">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp", line = 160,
     FQN="clang::CodeCompletionString::Chunk::CreateOptional", NM="_ZN5clang20CodeCompletionString5Chunk14CreateOptionalEPS0_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang20CodeCompletionString5Chunk14CreateOptionalEPS0_")
    //</editor-fold>
    public static CodeCompletionString.Chunk CreateOptional(CodeCompletionString /*P*/ Optional) {
      Chunk Result/*J*/= new Chunk();
      Result.Kind = ChunkKind.CK_Optional;
      Result.Unnamed_field1.Optional = Optional;
      return Result;
    }

    
    /// \brief Create a new placeholder chunk.
    //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionString::Chunk::CreatePlaceholder">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp", line = 168,
     FQN="clang::CodeCompletionString::Chunk::CreatePlaceholder", NM="_ZN5clang20CodeCompletionString5Chunk17CreatePlaceholderEPKc",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang20CodeCompletionString5Chunk17CreatePlaceholderEPKc")
    //</editor-fold>
    public static CodeCompletionString.Chunk CreatePlaceholder(/*const*/char$ptr/*char P*/ Placeholder) {
      return new Chunk(ChunkKind.CK_Placeholder, Placeholder);
    }

    
    /// \brief Create a new informative chunk.
    //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionString::Chunk::CreateInformative">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp", line = 173,
     FQN="clang::CodeCompletionString::Chunk::CreateInformative", NM="_ZN5clang20CodeCompletionString5Chunk17CreateInformativeEPKc",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang20CodeCompletionString5Chunk17CreateInformativeEPKc")
    //</editor-fold>
    public static CodeCompletionString.Chunk CreateInformative(/*const*/char$ptr/*char P*/ Informative) {
      return new Chunk(ChunkKind.CK_Informative, Informative);
    }

    
    /// \brief Create a new result type chunk.
    //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionString::Chunk::CreateResultType">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp", line = 178,
     FQN="clang::CodeCompletionString::Chunk::CreateResultType", NM="_ZN5clang20CodeCompletionString5Chunk16CreateResultTypeEPKc",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang20CodeCompletionString5Chunk16CreateResultTypeEPKc")
    //</editor-fold>
    public static CodeCompletionString.Chunk CreateResultType(/*const*/char$ptr/*char P*/ ResultType) {
      return new Chunk(ChunkKind.CK_ResultType, ResultType);
    }

    
    /// \brief Create a new current-parameter chunk.
    //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionString::Chunk::CreateCurrentParameter">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp", line = 183,
     FQN="clang::CodeCompletionString::Chunk::CreateCurrentParameter", NM="_ZN5clang20CodeCompletionString5Chunk22CreateCurrentParameterEPKc",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang20CodeCompletionString5Chunk22CreateCurrentParameterEPKc")
    //</editor-fold>
    public static CodeCompletionString.Chunk CreateCurrentParameter(/*const*/char$ptr/*char P*/ CurrentParameter) {
      return new Chunk(ChunkKind.CK_CurrentParameter, CurrentParameter);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionString::Chunk::Chunk">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 385,
     FQN="clang::CodeCompletionString::Chunk::Chunk", NM="_ZN5clang20CodeCompletionString5ChunkC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang20CodeCompletionString5ChunkC1EOS1_")
    //</editor-fold>
    public /*inline*/ Chunk(JD$Move _dparam, final Chunk /*&&*/$Prm0) {
      // : Kind(static_cast<Chunk &&>().Kind), Unnamed_field1(static_cast<Chunk &&>().) 
      //START JInit
      this.Kind = $Prm0.Kind;
      this.Unnamed_field1 = new Unnamed_union1(JD$Move.INSTANCE, $Prm0.Unnamed_field1);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionString::Chunk::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 385,
     FQN="clang::CodeCompletionString::Chunk::operator=", NM="_ZN5clang20CodeCompletionString5ChunkaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang20CodeCompletionString5ChunkaSERKS1_")
    //</editor-fold>
    public /*inline*/ Chunk /*&*/ $assign(final /*const*/ Chunk /*&*/ $Prm0) {
      this.Kind = $Prm0.Kind;
      this.Unnamed_field1.$assign($Prm0.Unnamed_field1);
      return /*Deref*/this;
    }


    @Override public Chunk clone() { return new Chunk().$assign(this); }
    
    @Override public String toString() {
      return "" + "Kind=" + Kind // NOI18N
                + ", Unnamed_field1=" + Unnamed_field1; // NOI18N
    }
  };
/*private:*/
  /// \brief The number of chunks stored in this string.
  private /*JCHAR unsigned int*/ char NumChunks /*: 16*/;
  
  /// \brief The number of annotations for this code-completion result.
  private /*JCHAR unsigned int*/ char NumAnnotations /*: 16*/;
  
  /// \brief The priority of this code-completion string.
  /*friend*//*private*/ /*JCHAR unsigned int*/ char Priority /*: 16*/;
  
  /// \brief The availability of this code-completion result.
  /*friend*//*private*/ /*JBYTE unsigned int*/ byte Availability /*: 2*/;
  
  /// \brief The name of the parent context.
  /*friend*//*private*/ StringRef ParentName;
  
  /// \brief A brief documentation comment attached to the declaration of
  /// entity being completed by this result.
  /*friend*//*private*/ /*const*/char$ptr/*char P*/ BriefComment;
  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionString::CodeCompletionString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 446,
   FQN="clang::CodeCompletionString::CodeCompletionString", NM="_ZN5clang20CodeCompletionStringC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang20CodeCompletionStringC1ERKS0_")
  //</editor-fold>
  /*friend*//*private*/ CodeCompletionString(final /*const*/ CodeCompletionString /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionString::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 447,
   FQN="clang::CodeCompletionString::operator=", NM="_ZN5clang20CodeCompletionStringaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang20CodeCompletionStringaSERKS0_")
  //</editor-fold>
  private void $assign(final /*const*/ CodeCompletionString /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionString::CodeCompletionString">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp", line = 189,
   FQN="clang::CodeCompletionString::CodeCompletionString", NM="_ZN5clang20CodeCompletionStringC1EPKNS0_5ChunkEjj18CXAvailabilityKindPPKcjN4llvm9StringRefES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang20CodeCompletionStringC1EPKNS0_5ChunkEjj18CXAvailabilityKindPPKcjN4llvm9StringRefES6_")
  //</editor-fold>
  /*friend*//*private*/ CodeCompletionString(/*const*/ type$ptr<Chunk> /*P*/ Chunks, 
      /*uint*/int NumChunks, 
      /*uint*/int Priority, 
      CXAvailabilityKind Availability, 
      /*const*/type$ptr<char$ptr>/*char PP*/ Annotations, 
      /*uint*/int NumAnnotations, 
      StringRef ParentName, 
      /*const*/char$ptr/*char P*/ BriefComment) {
    // : NumChunks(NumChunks), NumAnnotations(NumAnnotations), Priority(Priority), Availability(Availability), ParentName(ParentName), BriefComment(BriefComment) 
    //START JInit
    this.NumChunks = $uint2uint_16bits(NumChunks);
    this.NumAnnotations = $uint2uint_16bits(NumAnnotations);
    this.Priority = $uint2uint_16bits(Priority);
    this.Availability = $uint2uint_2bits(Availability.getValue());
    this.ParentName = new StringRef(ParentName);
    this.BriefComment = $tryClone(BriefComment);
    //END JInit
    assert ($lesseq_uint(NumChunks, 0xFFFF));
    assert ($lesseq_uint(NumAnnotations, 0xFFFF));
    $this$plus$one = new Object[NumChunks+NumAnnotations];
    for (/*uint*/int I = 0; I != NumChunks; ++I)  {
      $this$plus$one[I] = $tryClone(Chunks.$at(I));
    }
    
    for (/*uint*/int I = 0; I != NumAnnotations; ++I)  {
      $this$plus$one[I+NumChunks] = $tryClone(Annotations.$at(I));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionString::~CodeCompletionString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 454,
   FQN="clang::CodeCompletionString::~CodeCompletionString", NM="_ZN5clang20CodeCompletionStringD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang20CodeCompletionStringD0Ev")
  //</editor-fold>
  public/*private*/ void $destroy()/* = default*/ {
    /*<<<default destructor: may be there is another TU where objects are created/destroyed?>>>*/
  }


  
  /*friend  class CodeCompletionBuilder*/
  /*friend  class CodeCompletionResult*/
/*public:*/
  /*typedef const Chunk *iterator*/
//  public final class iterator extends /*const*/ Chunk /*P*/ { };
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionString::begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 461,
   FQN="clang::CodeCompletionString::begin", NM="_ZNK5clang20CodeCompletionString5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZNK5clang20CodeCompletionString5beginEv")
  //</editor-fold>
  public type$ptr</*const*/ Chunk /*P*/ > begin() /*const*/ {
    return (type$ptr</*const*/ Chunk /*P*/ >)(type$ptr)create_type$ptr($this$plus$one);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionString::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 462,
   FQN="clang::CodeCompletionString::end", NM="_ZNK5clang20CodeCompletionString3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZNK5clang20CodeCompletionString3endEv")
  //</editor-fold>
  public type$ptr</*const*/ Chunk /*P*/ > end() /*const*/ {
    return begin().$add(NumChunks);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionString::empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 463,
   FQN="clang::CodeCompletionString::empty", NM="_ZNK5clang20CodeCompletionString5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZNK5clang20CodeCompletionString5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    return NumChunks == $int2uint_16bits(0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionString::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 464,
   FQN="clang::CodeCompletionString::size", NM="_ZNK5clang20CodeCompletionString4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZNK5clang20CodeCompletionString4sizeEv")
  //</editor-fold>
  public /*uint*/int size() /*const*/ {
    return NumChunks;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionString::operator[]">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 466,
   FQN="clang::CodeCompletionString::operator[]", NM="_ZNK5clang20CodeCompletionStringixEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZNK5clang20CodeCompletionStringixEj")
  //</editor-fold>
  public /*const*/ Chunk /*&*/ $at(/*uint*/int I) /*const*/ {
    assert ($less_uint(I, size())) : "Chunk index out-of-range";
    return begin().$at(I);
  }

  
  /// \brief Returns the text in the TypedText chunk.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionString::getTypedText">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp", line = 246,
   FQN="clang::CodeCompletionString::getTypedText", NM="_ZNK5clang20CodeCompletionString12getTypedTextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZNK5clang20CodeCompletionString12getTypedTextEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getTypedText() /*const*/ {
    for (type$ptr</*const*/ Chunk /*P*/ > C = $tryClone(begin()), /*P*/ CEnd = $tryClone(end()); $noteq_ptr(C, CEnd); C.$preInc())  {
      if (C./*->*/$star().Kind == ChunkKind.CK_TypedText) {
        return C./*->*/$star().Unnamed_field1.Text;
      }
    }
    
    return null;
  }

  
  /// \brief Retrieve the priority of this code completion result.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionString::getPriority">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 475,
   FQN="clang::CodeCompletionString::getPriority", NM="_ZNK5clang20CodeCompletionString11getPriorityEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZNK5clang20CodeCompletionString11getPriorityEv")
  //</editor-fold>
  public /*uint*/int getPriority() /*const*/ {
    return Priority;
  }

  
  /// \brief Retrieve the availability of this code completion result.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionString::getAvailability">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 478,
   FQN="clang::CodeCompletionString::getAvailability", NM="_ZNK5clang20CodeCompletionString15getAvailabilityEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZNK5clang20CodeCompletionString15getAvailabilityEv")
  //</editor-fold>
  public /*uint*/int getAvailability() /*const*/ {
    return Availability;
  }

  
  /// \brief Retrieve the number of annotations for this code completion result.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionString::getAnnotationCount">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp", line = 213,
   FQN="clang::CodeCompletionString::getAnnotationCount", NM="_ZNK5clang20CodeCompletionString18getAnnotationCountEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZNK5clang20CodeCompletionString18getAnnotationCountEv")
  //</editor-fold>
  public /*uint*/int getAnnotationCount() /*const*/ {
    return NumAnnotations;
  }

  
  /// \brief Retrieve the annotation string specified by \c AnnotationNr.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionString::getAnnotation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp", line = 217,
   FQN="clang::CodeCompletionString::getAnnotation", NM="_ZNK5clang20CodeCompletionString13getAnnotationEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZNK5clang20CodeCompletionString13getAnnotationEj")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getAnnotation(/*uint*/int AnnotationNr) /*const*/ {
    if ($less_uint(AnnotationNr, NumAnnotations)) {
      return ((/*const*/type$ptr<char$ptr>/*char P const P*/ )reinterpret_cast(/*const*/type$ptr.class, end())).$at(AnnotationNr);
    } else {
      return null;
    }
  }

  
  /// \brief Retrieve the name of the parent context.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionString::getParentContextName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 487,
   FQN="clang::CodeCompletionString::getParentContextName", NM="_ZNK5clang20CodeCompletionString20getParentContextNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZNK5clang20CodeCompletionString20getParentContextNameEv")
  //</editor-fold>
  public StringRef getParentContextName() /*const*/ {
    return new StringRef(ParentName);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionString::getBriefComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 491,
   FQN="clang::CodeCompletionString::getBriefComment", NM="_ZNK5clang20CodeCompletionString15getBriefCommentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZNK5clang20CodeCompletionString15getBriefCommentEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getBriefComment() /*const*/ {
    return BriefComment;
  }

  
  /// \brief Retrieve a string representation of the code completion string,
  /// which is mainly useful for debugging.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionString::getAsString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp", line = 225,
   FQN="clang::CodeCompletionString::getAsString", NM="_ZNK5clang20CodeCompletionString11getAsStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZNK5clang20CodeCompletionString11getAsStringEv")
  //</editor-fold>
  public std.string getAsString() /*const*/ {
    raw_string_ostream OS = null;
    try {
      std.string Result/*J*/= new std.string();
      OS/*J*/= new raw_string_ostream(Result);
      
      for (type$ptr</*const*/ Chunk /*P*/ > C = $tryClone(begin()), /*P*/ CEnd = $tryClone(end()); $noteq_ptr(C, CEnd); C.$preInc()) {
        switch (C./*->*/$star().Kind) {
         case CK_Optional:
          OS.$out(/*KEEP_STR*/"{#").$out(C./*->*/$star().Unnamed_field1.Optional.getAsString()).$out(/*KEEP_STR*/"#}");
          break;
         case CK_Placeholder:
          OS.$out(/*KEEP_STR*/"<#").$out(C./*->*/$star().Unnamed_field1.Text).$out(/*KEEP_STR*/"#>");
          break;
         case CK_Informative:
         case CK_ResultType:
          OS.$out(/*KEEP_STR*/"[#").$out(C./*->*/$star().Unnamed_field1.Text).$out(/*KEEP_STR*/"#]");
          break;
         case CK_CurrentParameter:
          OS.$out(/*KEEP_STR*/"<#").$out(C./*->*/$star().Unnamed_field1.Text).$out(/*KEEP_STR*/"#>");
          break;
         default:
          OS.$out(C./*->*/$star().Unnamed_field1.Text);
          break;
        }
      }
      return new std.string(OS.str());
    } finally {
      if (OS != null) { OS.$destroy(); }
    }
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  /*this + 1*/ private Object[] $this$plus$one;
  @Override public Iterator<Chunk> iterator() {return new JavaIterator(begin(), end());}

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "NumChunks=" + $ushort2uint(NumChunks) // NOI18N
              + ", NumAnnotations=" + $ushort2uint(NumAnnotations) // NOI18N
              + ", Priority=" + $ushort2uint(Priority) // NOI18N
              + ", Availability=" + $uchar2uint(Availability) // NOI18N
              + ", ParentName=" + ParentName // NOI18N
              + ", BriefComment=" + BriefComment; // NOI18N
  }
}
