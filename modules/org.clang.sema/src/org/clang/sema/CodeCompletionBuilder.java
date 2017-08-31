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
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.clangc.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


/// \brief A builder class used to construct new code-completion strings.
//<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionBuilder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 546,
 FQN="clang::CodeCompletionBuilder", NM="_ZN5clang21CodeCompletionBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang21CodeCompletionBuilderE")
//</editor-fold>
public class CodeCompletionBuilder implements Destructors.ClassWithDestructor {
/*public:*/
  /*typedef CodeCompletionString::Chunk Chunk*/
//  public final class Chunk extends CodeCompletionString.Chunk{ };
/*private:*/
  private final CodeCompletionAllocator /*&*/ Allocator;
  private final CodeCompletionTUInfo /*&*/ CCTUInfo;
  private /*uint*/int Priority;
  private CXAvailabilityKind Availability;
  private StringRef ParentName;
  private /*const*/char$ptr/*char P*/ BriefComment;
  
  /// \brief The chunks stored in this string.
  private SmallVector<CodeCompletionString.Chunk> Chunks;
  
  private SmallVector</*const*/char$ptr/*char P*//*,  2*/> Annotations;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionBuilder::CodeCompletionBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 564,
   FQN="clang::CodeCompletionBuilder::CodeCompletionBuilder", NM="_ZN5clang21CodeCompletionBuilderC1ERNS_23CodeCompletionAllocatorERNS_20CodeCompletionTUInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang21CodeCompletionBuilderC1ERNS_23CodeCompletionAllocatorERNS_20CodeCompletionTUInfoE")
  //</editor-fold>
  public CodeCompletionBuilder(final CodeCompletionAllocator /*&*/ Allocator, 
      final CodeCompletionTUInfo /*&*/ CCTUInfo) {
    // : Allocator(Allocator), CCTUInfo(CCTUInfo), Priority(0), Availability(CXAvailability_Available), ParentName(), BriefComment(null), Chunks(), Annotations() 
    //START JInit
    this./*&*/Allocator=/*&*/Allocator;
    this./*&*/CCTUInfo=/*&*/CCTUInfo;
    this.Priority = 0;
    this.Availability = CXAvailabilityKind.CXAvailability_Available;
    this.ParentName = new StringRef();
    this.BriefComment = null;
    this.Chunks = new SmallVector<CodeCompletionString.Chunk>(4, new CodeCompletionString.Chunk());
    this.Annotations = new SmallVector</*const*/char$ptr/*char P*//*,  2*/>(2, null);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionBuilder::CodeCompletionBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 570,
   FQN="clang::CodeCompletionBuilder::CodeCompletionBuilder", NM="_ZN5clang21CodeCompletionBuilderC1ERNS_23CodeCompletionAllocatorERNS_20CodeCompletionTUInfoEj18CXAvailabilityKind",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang21CodeCompletionBuilderC1ERNS_23CodeCompletionAllocatorERNS_20CodeCompletionTUInfoEj18CXAvailabilityKind")
  //</editor-fold>
  public CodeCompletionBuilder(final CodeCompletionAllocator /*&*/ Allocator, 
      final CodeCompletionTUInfo /*&*/ CCTUInfo, 
      /*uint*/int Priority, CXAvailabilityKind Availability) {
    // : Allocator(Allocator), CCTUInfo(CCTUInfo), Priority(Priority), Availability(Availability), ParentName(), BriefComment(null), Chunks(), Annotations() 
    //START JInit
    this./*&*/Allocator=/*&*/Allocator;
    this./*&*/CCTUInfo=/*&*/CCTUInfo;
    this.Priority = Priority;
    this.Availability = Availability;
    this.ParentName = new StringRef();
    this.BriefComment = null;
    this.Chunks = new SmallVector<CodeCompletionString.Chunk>(4, new CodeCompletionString.Chunk());
    this.Annotations = new SmallVector</*const*/char$ptr/*char P*//*,  2*/>(2, null);
    //END JInit
  }

  
  /// \brief Retrieve the allocator into which the code completion
  /// strings should be allocated.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionBuilder::getAllocator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 579,
   FQN="clang::CodeCompletionBuilder::getAllocator", NM="_ZNK5clang21CodeCompletionBuilder12getAllocatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZNK5clang21CodeCompletionBuilder12getAllocatorEv")
  //</editor-fold>
  public CodeCompletionAllocator /*&*/ getAllocator() /*const*/ {
    return Allocator;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionBuilder::getCodeCompletionTUInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 581,
   FQN="clang::CodeCompletionBuilder::getCodeCompletionTUInfo", NM="_ZNK5clang21CodeCompletionBuilder23getCodeCompletionTUInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZNK5clang21CodeCompletionBuilder23getCodeCompletionTUInfoEv")
  //</editor-fold>
  public CodeCompletionTUInfo /*&*/ getCodeCompletionTUInfo() /*const*/ {
    return CCTUInfo;
  }

  
  /// \brief Take the resulting completion string.
  ///
  /// This operation can only be performed once.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionBuilder::TakeString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp", line = 328,
   FQN="clang::CodeCompletionBuilder::TakeString", NM="_ZN5clang21CodeCompletionBuilder10TakeStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang21CodeCompletionBuilder10TakeStringEv")
  //</editor-fold>
  public CodeCompletionString /*P*/ TakeString() {
    CodeCompletionString /*P*/ Result = /*FIXME:NEW_EXPR*//*new (Mem)*/ new CodeCompletionString(Chunks.data(), Chunks.size(), 
        Priority, Availability, 
        Annotations.data(), Annotations.size(), 
        new StringRef(ParentName), BriefComment);
    Chunks.clear();
    return Result;
  }

  
  /// \brief Add a new typed-text chunk.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionBuilder::AddTypedTextChunk">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp", line = 342,
   FQN="clang::CodeCompletionBuilder::AddTypedTextChunk", NM="_ZN5clang21CodeCompletionBuilder17AddTypedTextChunkEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang21CodeCompletionBuilder17AddTypedTextChunkEPKc")
  //</editor-fold>
  public void AddTypedTextChunk(/*const*/char$ptr/*char P*/ Text) {
    Chunks.push_back(new CodeCompletionString.Chunk(CodeCompletionString.ChunkKind.CK_TypedText, Text));
  }

  
  /// \brief Add a new text chunk.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionBuilder::AddTextChunk">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp", line = 346,
   FQN="clang::CodeCompletionBuilder::AddTextChunk", NM="_ZN5clang21CodeCompletionBuilder12AddTextChunkEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang21CodeCompletionBuilder12AddTextChunkEPKc")
  //</editor-fold>
  public void AddTextChunk(/*const*/char$ptr/*char P*/ Text) {
    Chunks.push_back(CodeCompletionString.Chunk.CreateText(Text));
  }

  
  /// \brief Add a new optional chunk.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionBuilder::AddOptionalChunk">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp", line = 350,
   FQN="clang::CodeCompletionBuilder::AddOptionalChunk", NM="_ZN5clang21CodeCompletionBuilder16AddOptionalChunkEPNS_20CodeCompletionStringE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang21CodeCompletionBuilder16AddOptionalChunkEPNS_20CodeCompletionStringE")
  //</editor-fold>
  public void AddOptionalChunk(CodeCompletionString /*P*/ Optional) {
    Chunks.push_back(CodeCompletionString.Chunk.CreateOptional(Optional));
  }

  
  /// \brief Add a new placeholder chunk.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionBuilder::AddPlaceholderChunk">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp", line = 354,
   FQN="clang::CodeCompletionBuilder::AddPlaceholderChunk", NM="_ZN5clang21CodeCompletionBuilder19AddPlaceholderChunkEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang21CodeCompletionBuilder19AddPlaceholderChunkEPKc")
  //</editor-fold>
  public void AddPlaceholderChunk(/*const*/char$ptr/*char P*/ Placeholder) {
    Chunks.push_back(CodeCompletionString.Chunk.CreatePlaceholder(Placeholder));
  }

  
  /// \brief Add a new informative chunk.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionBuilder::AddInformativeChunk">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp", line = 358,
   FQN="clang::CodeCompletionBuilder::AddInformativeChunk", NM="_ZN5clang21CodeCompletionBuilder19AddInformativeChunkEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang21CodeCompletionBuilder19AddInformativeChunkEPKc")
  //</editor-fold>
  public void AddInformativeChunk(/*const*/char$ptr/*char P*/ Text) {
    Chunks.push_back(CodeCompletionString.Chunk.CreateInformative(Text));
  }

  
  /// \brief Add a new result-type chunk.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionBuilder::AddResultTypeChunk">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp", line = 362,
   FQN="clang::CodeCompletionBuilder::AddResultTypeChunk", NM="_ZN5clang21CodeCompletionBuilder18AddResultTypeChunkEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang21CodeCompletionBuilder18AddResultTypeChunkEPKc")
  //</editor-fold>
  public void AddResultTypeChunk(/*const*/char$ptr/*char P*/ ResultType) {
    Chunks.push_back(CodeCompletionString.Chunk.CreateResultType(ResultType));
  }

  
  /// \brief Add a new current-parameter chunk.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionBuilder::AddCurrentParameterChunk">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp", line = 366,
   FQN="clang::CodeCompletionBuilder::AddCurrentParameterChunk", NM="_ZN5clang21CodeCompletionBuilder24AddCurrentParameterChunkEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang21CodeCompletionBuilder24AddCurrentParameterChunkEPKc")
  //</editor-fold>
  public void AddCurrentParameterChunk(/*const*/char$ptr/*char P*/ CurrentParameter) {
    Chunks.push_back(CodeCompletionString.Chunk.CreateCurrentParameter(CurrentParameter));
  }

  
  /// \brief Add a new chunk.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionBuilder::AddChunk">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp", line = 371,
   FQN="clang::CodeCompletionBuilder::AddChunk", NM="_ZN5clang21CodeCompletionBuilder8AddChunkENS_20CodeCompletionString9ChunkKindEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang21CodeCompletionBuilder8AddChunkENS_20CodeCompletionString9ChunkKindEPKc")
  //</editor-fold>
  public void AddChunk(CodeCompletionString.ChunkKind CK) {
    AddChunk(CK, 
          $EMPTY);
  }
  public void AddChunk(CodeCompletionString.ChunkKind CK, 
          /*const*/char$ptr/*char P*/ Text/*= ""*/) {
    Chunks.push_back(new CodeCompletionString.Chunk(CK, Text));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionBuilder::AddAnnotation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 612,
   FQN="clang::CodeCompletionBuilder::AddAnnotation", NM="_ZN5clang21CodeCompletionBuilder13AddAnnotationEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang21CodeCompletionBuilder13AddAnnotationEPKc")
  //</editor-fold>
  public void AddAnnotation(/*const*/char$ptr/*char P*/ A) {
    Annotations.push_back(A);
  }

  
  /// \brief Add the parent context information to this code completion.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionBuilder::addParentContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp", line = 376,
   FQN="clang::CodeCompletionBuilder::addParentContext", NM="_ZN5clang21CodeCompletionBuilder16addParentContextEPKNS_11DeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang21CodeCompletionBuilder16addParentContextEPKNS_11DeclContextE")
  //</editor-fold>
  public void addParentContext(/*const*/ DeclContext /*P*/ DC) {
    if (DC.isTranslationUnit()) {
      return;
    }
    if (DC.isFunctionOrMethod()) {
      return;
    }
    
    /*const*/ NamedDecl /*P*/ ND = dyn_cast_NamedDecl(DC);
    if (!(ND != null)) {
      return;
    }
    
    ParentName.$assignMove(getCodeCompletionTUInfo().getParentName(DC));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionBuilder::getBriefComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 617,
   FQN="clang::CodeCompletionBuilder::getBriefComment", NM="_ZNK5clang21CodeCompletionBuilder15getBriefCommentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZNK5clang21CodeCompletionBuilder15getBriefCommentEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getBriefComment() /*const*/ {
    return BriefComment;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionBuilder::addBriefComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp", line = 391,
   FQN="clang::CodeCompletionBuilder::addBriefComment", NM="_ZN5clang21CodeCompletionBuilder15addBriefCommentEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang21CodeCompletionBuilder15addBriefCommentEN4llvm9StringRefE")
  //</editor-fold>
  public void addBriefComment(StringRef Comment) {
    BriefComment = $tryClone(Allocator.CopyString(new Twine(Comment)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionBuilder::getParentName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 620,
   FQN="clang::CodeCompletionBuilder::getParentName", NM="_ZNK5clang21CodeCompletionBuilder13getParentNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZNK5clang21CodeCompletionBuilder13getParentNameEv")
  //</editor-fold>
  public StringRef getParentName() /*const*/ {
    return new StringRef(ParentName);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::CodeCompletionBuilder::~CodeCompletionBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 546,
   FQN="clang::CodeCompletionBuilder::~CodeCompletionBuilder", NM="_ZN5clang21CodeCompletionBuilderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang21CodeCompletionBuilderD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Annotations.$destroy();
    Chunks.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Allocator=" + "[CodeCompletionAllocator]" // NOI18N
              + ", CCTUInfo=" + CCTUInfo // NOI18N
              + ", Priority=" + Priority // NOI18N
              + ", Availability=" + Availability // NOI18N
              + ", ParentName=" + ParentName // NOI18N
              + ", BriefComment=" + BriefComment // NOI18N
              + ", Chunks=" + Chunks // NOI18N
              + ", Annotations=" + Annotations; // NOI18N
  }
}
