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

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.impl.*;
import static org.clang.ast.ASTContextGlobals.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstStatementsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstRTTI.*;
import org.clang.basic.llvm.DenseMapInfoFileID;


/// \brief Imports selected nodes from one AST context into another context,
/// merging AST nodes where appropriate.
//<editor-fold defaultstate="collapsed" desc="clang::ASTImporter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTImporter.h", line = 39,
 FQN="clang::ASTImporter", NM="_ZN5clang11ASTImporterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang11ASTImporterE")
//</editor-fold>
public class ASTImporter implements Destructors.ClassWithDestructor {
/*public:*/
  /*typedef llvm::DenseSet<std::pair<Decl *, Decl *> > NonEquivalentDeclSet*/
//  public final class NonEquivalentDeclSet extends DenseSet<std.pair<Decl /*P*/ , Decl /*P*/ > >{ };
/*private:*/
  /// \brief The contexts we're importing to and from.
  private final ASTContext /*&*/ ToContext;
  private final ASTContext /*&*/ FromContext;
  
  /// \brief The file managers we're importing to and from.
  private final FileManager /*&*/ ToFileManager;
  private final FileManager /*&*/ FromFileManager;
  
  /// \brief Whether to perform a minimal import.
  private boolean Minimal;
  
  /// \brief Whether the last diagnostic came from the "from" context.
  private boolean LastDiagFromFrom;
  
  /// \brief Mapping from the already-imported types in the "from" context
  /// to the corresponding types in the "to" context.
  private DenseMap</*const*/ Type /*P*/ , /*const*/ Type /*P*/ > ImportedTypes;
  
  /// \brief Mapping from the already-imported declarations in the "from"
  /// context to the corresponding declarations in the "to" context.
  private DenseMap<Decl /*P*/ , Decl /*P*/ > ImportedDecls;
  
  /// \brief Mapping from the already-imported statements in the "from"
  /// context to the corresponding statements in the "to" context.
  private DenseMap<Stmt /*P*/ , Stmt /*P*/ > ImportedStmts;
  
  /// \brief Mapping from the already-imported FileIDs in the "from" source
  /// manager to the corresponding FileIDs in the "to" source manager.
  private DenseMap<FileID, FileID> ImportedFileIDs;
  
  /// \brief Imported, anonymous tag declarations that are missing their 
  /// corresponding typedefs.
  private SmallVector<TagDecl /*P*/ > AnonTagsWithPendingTypedefs;
  
  /// \brief Declaration (from, to) pairs that are known not to be equivalent
  /// (which we have already complained about).
  private DenseSet<std.pair<Decl /*P*/ , Decl /*P*/ > > NonEquivalentDecls;
/*public:*/
  /// \brief Create a new AST importer.
  ///
  /// \param ToContext The context we'll be importing into.
  ///
  /// \param ToFileManager The file manager we'll be importing into.
  ///
  /// \param FromContext The context we'll be importing from.
  ///
  /// \param FromFileManager The file manager we'll be importing into.
  ///
  /// \param MinimalImport If true, the importer will attempt to import
  /// as little as it can, e.g., by importing declarations as forward
  /// declarations that can be completed at a later point.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTImporter::ASTImporter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 6035,
   FQN="clang::ASTImporter::ASTImporter", NM="_ZN5clang11ASTImporterC1ERNS_10ASTContextERNS_11FileManagerES2_S4_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang11ASTImporterC1ERNS_10ASTContextERNS_11FileManagerES2_S4_b")
  //</editor-fold>
  public ASTImporter(final ASTContext /*&*/ ToContext, final FileManager /*&*/ ToFileManager, 
      final ASTContext /*&*/ FromContext, final FileManager /*&*/ FromFileManager, 
      boolean MinimalImport) {
    // : ToContext(ToContext), FromContext(FromContext), ToFileManager(ToFileManager), FromFileManager(FromFileManager), Minimal(MinimalImport), LastDiagFromFrom(false), ImportedTypes(), ImportedDecls(), ImportedStmts(), ImportedFileIDs(), AnonTagsWithPendingTypedefs(), NonEquivalentDecls() 
    //START JInit
    this./*&*/ToContext=/*&*/ToContext;
    this./*&*/FromContext=/*&*/FromContext;
    this./*&*/ToFileManager=/*&*/ToFileManager;
    this./*&*/FromFileManager=/*&*/FromFileManager;
    this.Minimal = MinimalImport;
    this.LastDiagFromFrom = false;
    this.ImportedTypes = new DenseMap</*const*/ Type /*P*/ , /*const*/ Type /*P*/ >(DenseMapInfo$LikePtr.$Info(), (/*const*/ Type /*P*/ )null);
    this.ImportedDecls = new DenseMap<Decl /*P*/ , Decl /*P*/ >(DenseMapInfo$LikePtr.$Info(), (Decl /*P*/ )null);
    this.ImportedStmts = new DenseMap<Stmt /*P*/ , Stmt /*P*/ >(DenseMapInfo$LikePtr.$Info(), (Stmt /*P*/ )null);
    this.ImportedFileIDs = new DenseMap<FileID, FileID>(DenseMapInfoFileID.$Info(), new FileID());
    this.AnonTagsWithPendingTypedefs = new SmallVector<TagDecl /*P*/ >(4, (TagDecl /*P*/ )null);
    this.NonEquivalentDecls = new DenseSet<std.pair<Decl /*P*/ , Decl /*P*/ > >(new DenseMapInfoPair(DenseMapInfo$LikePtr.$Info(), DenseMapInfo$LikePtr.$Info()));
    //END JInit
    ImportedDecls.$set(FromContext.getTranslationUnitDecl(), 
      ToContext.getTranslationUnitDecl());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTImporter::~ASTImporter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 6046,
   FQN="clang::ASTImporter::~ASTImporter", NM="_ZN5clang11ASTImporterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang11ASTImporterD0Ev")
  //</editor-fold>
  public void $destroy() {
    //START JDestroy
    NonEquivalentDecls.$destroy();
    AnonTagsWithPendingTypedefs.$destroy();
    ImportedFileIDs.$destroy();
    ImportedStmts.$destroy();
    ImportedDecls.$destroy();
    ImportedTypes.$destroy();
    //END JDestroy
  }

  
  /// \brief Whether the importer will perform a minimal import, creating
  /// to-be-completed forward declarations when possible.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTImporter::isMinimalImport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTImporter.h", line = 102,
   FQN="clang::ASTImporter::isMinimalImport", NM="_ZNK5clang11ASTImporter15isMinimalImportEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZNK5clang11ASTImporter15isMinimalImportEv")
  //</editor-fold>
  public boolean isMinimalImport() /*const*/ {
    return Minimal;
  }

  
  /// \brief Import the given type from the "from" context into the "to"
  /// context.
  ///
  /// \returns the equivalent type in the "to" context, or a NULL type if
  /// an error occurred.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTImporter::Import">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 6048,
   FQN="clang::ASTImporter::Import", NM="_ZN5clang11ASTImporter6ImportENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang11ASTImporter6ImportENS_8QualTypeE")
  //</editor-fold>
  public QualType Import(QualType FromT) {
    if (FromT.isNull()) {
      return new QualType();
    }
    
    /*const*/ Type /*P*/ fromTy = FromT.getTypePtr();
    
    // Check whether we've already imported this type.  
    DenseMapIterator</*const*/ Type /*P*/ , /*const*/ Type /*P*/ > Pos = ImportedTypes.find(fromTy);
    if (Pos.$noteq(/*NO_ITER_COPY*/ImportedTypes.end())) {
      return ToContext.getQualifiedType(Pos.$arrow().second, FromT.getLocalQualifiers());
    }
    
    // Import the type
    ASTNodeImporter Importer/*J*/= new ASTNodeImporter(/*Deref*/this);
    QualType ToT = Importer.Visit(fromTy);
    if (ToT.isNull()) {
      return ToT;
    }
    
    // Record the imported type.
    ImportedTypes.$set(fromTy, ToT.getTypePtr());
    
    return ToContext.getQualifiedType(new QualType(ToT), FromT.getLocalQualifiers());
  }

  
  /// \brief Import the given type source information from the
  /// "from" context into the "to" context.
  ///
  /// \returns the equivalent type source information in the "to"
  /// context, or NULL if an error occurred.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTImporter::Import">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 6072,
   FQN="clang::ASTImporter::Import", NM="_ZN5clang11ASTImporter6ImportEPNS_14TypeSourceInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang11ASTImporter6ImportEPNS_14TypeSourceInfoE")
  //</editor-fold>
  public TypeSourceInfo /*P*/ Import(TypeSourceInfo /*P*/ FromTSI) {
    if (!(FromTSI != null)) {
      return FromTSI;
    }
    
    // FIXME: For now we just create a "trivial" type source info based
    // on the type and a single location. Implement a real version of this.
    QualType T = Import(FromTSI.getType());
    if (T.isNull()) {
      return null;
    }
    
    return ToContext.getTrivialTypeSourceInfo(new QualType(T), 
        Import(FromTSI.getTypeLoc().getLocStart()));
  }

  
  /// \brief Import the given declaration from the "from" context into the 
  /// "to" context.
  ///
  /// \returns the equivalent declaration in the "to" context, or a NULL type 
  /// if an error occurred.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTImporter::Import">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 6097,
   FQN="clang::ASTImporter::Import", NM="_ZN5clang11ASTImporter6ImportEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang11ASTImporter6ImportEPNS_4DeclE")
  //</editor-fold>
  public Decl /*P*/ Import(Decl /*P*/ FromD) {
    if (!(FromD != null)) {
      return null;
    }
    
    ASTNodeImporter Importer/*J*/= new ASTNodeImporter(/*Deref*/this);
    
    // Check whether we've already imported this declaration.  
    DenseMapIterator<Decl /*P*/ , Decl /*P*/ > Pos = ImportedDecls.find(FromD);
    if (Pos.$noteq(/*NO_ITER_COPY*/ImportedDecls.end())) {
      Decl /*P*/ ToD = Pos.$arrow().second;
      Importer.ImportDefinitionIfNeeded(FromD, ToD);
      return ToD;
    }
    
    // Import the type
    Decl /*P*/ ToD = Importer.Visit(FromD);
    if (!(ToD != null)) {
      return null;
    }
    
    // Record the imported declaration.
    ImportedDecls.$set(FromD, ToD);
    {
      
      TagDecl /*P*/ FromTag = dyn_cast_TagDecl(FromD);
      if ((FromTag != null)) {
        // Keep track of anonymous tags that have an associated typedef.
        if ((FromTag.getTypedefNameForAnonDecl() != null)) {
          AnonTagsWithPendingTypedefs.push_back(FromTag);
        }
      } else {
        TypedefNameDecl /*P*/ FromTypedef = dyn_cast_TypedefNameDecl(FromD);
        if ((FromTypedef != null)) {
          // When we've finished transforming a typedef, see whether it was the
          // typedef for an anonymous tag.
          for (type$ptr<TagDecl /*P*/ /*P*/> FromTag$1 = $tryClone(AnonTagsWithPendingTypedefs.begin()), 
              /*P*/ FromTagEnd = $tryClone(AnonTagsWithPendingTypedefs.end());
               $noteq_ptr(FromTag$1, FromTagEnd); FromTag$1.$preInc()) {
            if ((FromTag$1.$star()).getTypedefNameForAnonDecl() == FromTypedef) {
              {
                TagDecl /*P*/ ToTag = cast_or_null_TagDecl(Import(FromTag$1.$star()));
                if ((ToTag != null)) {
                  // We found the typedef for an anonymous tag; link them.
                  ToTag.setTypedefNameForAnonDecl(cast_TypedefNameDecl(ToD));
                  AnonTagsWithPendingTypedefs.erase(FromTag$1);
                  break;
                }
              }
            }
          }
        }
      }
    }
    
    return ToD;
  }

  
  /// \brief Return the copy of the given declaration in the "to" context if
  /// it has already been imported from the "from" context.  Otherwise return
  /// NULL.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTImporter::GetAlreadyImportedOrNull">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 6086,
   FQN="clang::ASTImporter::GetAlreadyImportedOrNull", NM="_ZN5clang11ASTImporter24GetAlreadyImportedOrNullEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang11ASTImporter24GetAlreadyImportedOrNullEPNS_4DeclE")
  //</editor-fold>
  public Decl /*P*/ GetAlreadyImportedOrNull(Decl /*P*/ FromD) {
    DenseMapIterator<Decl /*P*/ , Decl /*P*/ > Pos = ImportedDecls.find(FromD);
    if (Pos.$noteq(/*NO_ITER_COPY*/ImportedDecls.end())) {
      Decl /*P*/ ToD = Pos.$arrow().second;
      new ASTNodeImporter(/*Deref*/this).ImportDefinitionIfNeeded(FromD, ToD);
      return ToD;
    } else {
      return null;
    }
  }

  
  /// \brief Import the given declaration context from the "from"
  /// AST context into the "to" AST context.
  ///
  /// \returns the equivalent declaration context in the "to"
  /// context, or a NULL type if an error occurred.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTImporter::ImportContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 6144,
   FQN="clang::ASTImporter::ImportContext", NM="_ZN5clang11ASTImporter13ImportContextEPNS_11DeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang11ASTImporter13ImportContextEPNS_11DeclContextE")
  //</editor-fold>
  public DeclContext /*P*/ ImportContext(DeclContext /*P*/ FromDC) {
    if (!(FromDC != null)) {
      return FromDC;
    }
    
    DeclContext /*P*/ ToDC = cast_or_null_DeclContext(Import(cast_Decl(FromDC)));
    if (!(ToDC != null)) {
      return null;
    }
    {
      
      // When we're using a record/enum/Objective-C class/protocol as a context, we 
      // need it to have a definition.
      RecordDecl /*P*/ ToRecord = dyn_cast_RecordDecl(ToDC);
      if ((ToRecord != null)) {
        RecordDecl /*P*/ FromRecord = cast_RecordDecl(FromDC);
        if (ToRecord.isCompleteDefinition()) {
          // Do nothing.
        } else if (FromRecord.isCompleteDefinition()) {
          new ASTNodeImporter(/*Deref*/this).ImportDefinition(FromRecord, ToRecord, 
              ASTNodeImporter.ImportDefinitionKind.IDK_Basic);
        } else {
          CompleteDecl(ToRecord);
        }
      } else {
        EnumDecl /*P*/ ToEnum = dyn_cast_EnumDecl(ToDC);
        if ((ToEnum != null)) {
          EnumDecl /*P*/ FromEnum = cast_EnumDecl(FromDC);
          if (ToEnum.isCompleteDefinition()) {
            // Do nothing.
          } else if (FromEnum.isCompleteDefinition()) {
            new ASTNodeImporter(/*Deref*/this).ImportDefinition(FromEnum, ToEnum, 
                ASTNodeImporter.ImportDefinitionKind.IDK_Basic);
          } else {
            CompleteDecl(ToEnum);
          }
        } else {
          ObjCInterfaceDecl /*P*/ ToClass = dyn_cast_ObjCInterfaceDecl(ToDC);
          if ((ToClass != null)) {
            ObjCInterfaceDecl /*P*/ FromClass = cast_ObjCInterfaceDecl(FromDC);
            if ((ToClass.getDefinition() != null)) {
              // Do nothing.
            } else {
              ObjCInterfaceDecl /*P*/ FromDef = FromClass.getDefinition();
              if ((FromDef != null)) {
                new ASTNodeImporter(/*Deref*/this).ImportDefinition(FromDef, ToClass, 
                    ASTNodeImporter.ImportDefinitionKind.IDK_Basic);
              } else {
                CompleteDecl(ToClass);
              }
            }
          } else {
            ObjCProtocolDecl /*P*/ ToProto = dyn_cast_ObjCProtocolDecl(ToDC);
            if ((ToProto != null)) {
              ObjCProtocolDecl /*P*/ FromProto = cast_ObjCProtocolDecl(FromDC);
              if ((ToProto.getDefinition() != null)) {
                // Do nothing.
              } else {
                ObjCProtocolDecl /*P*/ FromDef = FromProto.getDefinition();
                if ((FromDef != null)) {
                  new ASTNodeImporter(/*Deref*/this).ImportDefinition(FromDef, ToProto, 
                      ASTNodeImporter.ImportDefinitionKind.IDK_Basic);
                } else {
                  CompleteDecl(ToProto);
                }
              }
            }
          }
        }
      }
    }
    
    return ToDC;
  }

  
  /// \brief Import the given expression from the "from" context into the
  /// "to" context.
  ///
  /// \returns the equivalent expression in the "to" context, or NULL if
  /// an error occurred.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTImporter::Import">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 6199,
   FQN="clang::ASTImporter::Import", NM="_ZN5clang11ASTImporter6ImportEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang11ASTImporter6ImportEPNS_4ExprE")
  //</editor-fold>
  public Expr /*P*/ Import(Expr /*P*/ FromE) {
    if (!(FromE != null)) {
      return null;
    }
    
    return cast_or_null_Expr(Import(cast_Stmt(FromE)));
  }

  
  /// \brief Import the given statement from the "from" context into the
  /// "to" context.
  ///
  /// \returns the equivalent statement in the "to" context, or NULL if
  /// an error occurred.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTImporter::Import">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 6206,
   FQN="clang::ASTImporter::Import", NM="_ZN5clang11ASTImporter6ImportEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang11ASTImporter6ImportEPNS_4StmtE")
  //</editor-fold>
  public Stmt /*P*/ Import(Stmt /*P*/ FromS) {
    if (!(FromS != null)) {
      return null;
    }
    
    // Check whether we've already imported this declaration.  
    DenseMapIterator<Stmt /*P*/ , Stmt /*P*/ > Pos = ImportedStmts.find(FromS);
    if (Pos.$noteq(/*NO_ITER_COPY*/ImportedStmts.end())) {
      return Pos.$arrow().second;
    }
    
    // Import the type
    ASTNodeImporter Importer/*J*/= new ASTNodeImporter(/*Deref*/this);
    Stmt /*P*/ ToS = Importer.Visit(FromS);
    if (!(ToS != null)) {
      return null;
    }
    
    // Record the imported declaration.
    ImportedStmts.$set(FromS, ToS);
    return ToS;
  }

  
  /// \brief Import the given nested-name-specifier from the "from"
  /// context into the "to" context.
  ///
  /// \returns the equivalent nested-name-specifier in the "to"
  /// context, or NULL if an error occurred.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTImporter::Import">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 6226,
   FQN="clang::ASTImporter::Import", NM="_ZN5clang11ASTImporter6ImportEPNS_19NestedNameSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang11ASTImporter6ImportEPNS_19NestedNameSpecifierE")
  //</editor-fold>
  public NestedNameSpecifier /*P*/ Import(NestedNameSpecifier /*P*/ FromNNS) {
    if (!(FromNNS != null)) {
      return null;
    }
    
    NestedNameSpecifier /*P*/ prefix = Import(FromNNS.getPrefix());
    switch (FromNNS.getKind()) {
     case Identifier:
      {
        IdentifierInfo /*P*/ II = Import(FromNNS.getAsIdentifier());
        if ((II != null)) {
          return NestedNameSpecifier.Create(ToContext, prefix, II);
        }
      }
      return null;
     case Namespace:
      {
        NamespaceDecl /*P*/ NS = cast_NamespaceDecl(Import(FromNNS.getAsNamespace()));
        if ((NS != null)) {
          return NestedNameSpecifier.Create(ToContext, prefix, NS);
        }
      }
      return null;
     case NamespaceAlias:
      {
        NamespaceAliasDecl /*P*/ NSAD = cast_NamespaceAliasDecl(Import(FromNNS.getAsNamespaceAlias()));
        if ((NSAD != null)) {
          return NestedNameSpecifier.Create(ToContext, prefix, NSAD);
        }
      }
      return null;
     case Global:
      return NestedNameSpecifier.GlobalSpecifier(ToContext);
     case Super:
      {
        CXXRecordDecl /*P*/ RD = cast_CXXRecordDecl(Import(FromNNS.getAsRecordDecl()));
        if ((RD != null)) {
          return NestedNameSpecifier.SuperSpecifier(ToContext, RD);
        }
      }
      return null;
     case TypeSpec:
     case TypeSpecWithTemplate:
      {
        QualType T = Import(new QualType(FromNNS.getAsType(), 0/*U*/));
        if (!T.isNull()) {
          boolean bTemplate = FromNNS.getKind()
             == NestedNameSpecifier.SpecifierKind.TypeSpecWithTemplate;
          return NestedNameSpecifier.Create(ToContext, prefix, 
              bTemplate, T.getTypePtr());
        }
      }
      return null;
    }
    throw new llvm_unreachable("Invalid nested name specifier kind");
  }

  
  /// \brief Import the given nested-name-specifier from the "from"
  /// context into the "to" context.
  ///
  /// \returns the equivalent nested-name-specifier in the "to"
  /// context.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTImporter::Import">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 6279,
   FQN="clang::ASTImporter::Import", NM="_ZN5clang11ASTImporter6ImportENS_22NestedNameSpecifierLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang11ASTImporter6ImportENS_22NestedNameSpecifierLocE")
  //</editor-fold>
  public NestedNameSpecifierLoc Import(NestedNameSpecifierLoc FromNNS) {
    // FIXME: Implement!
    return new NestedNameSpecifierLoc();
  }

  
  /// \brief Import the goven template name from the "from" context into the
  /// "to" context.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTImporter::Import">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 6284,
   FQN="clang::ASTImporter::Import", NM="_ZN5clang11ASTImporter6ImportENS_12TemplateNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang11ASTImporter6ImportENS_12TemplateNameE")
  //</editor-fold>
  public TemplateName Import(TemplateName From) {
    switch (From.getKind()) {
     case Template:
      {
        TemplateDecl /*P*/ ToTemplate = cast_or_null_TemplateDecl(Import(From.getAsTemplateDecl()));
        if ((ToTemplate != null)) {
          return new TemplateName(ToTemplate);
        }
      }
      
      return new TemplateName();
     case OverloadedTemplate:
      {
        OverloadedTemplateStorage /*P*/ FromStorage = From.getAsOverloadedTemplate();
        UnresolvedSet ToTemplates/*J*/= new UnresolvedSet(2);
        for (type$ptr<NamedDecl /*P*/ /*const*/ /*P*/> I = $tryClone(FromStorage.begin()), 
            /*P*/ /*const*/ /*P*/ E = $tryClone(FromStorage.end());
             $noteq_ptr(I, E); I.$preInc()) {
          {
            NamedDecl /*P*/ To = cast_or_null_NamedDecl(Import(I.$star()));
            if ((To != null)) {
              ToTemplates.addDecl(To);
            } else {
              return new TemplateName();
            }
          }
        }
        return ToContext.getOverloadedTemplateName(ToTemplates.begin(), 
            ToTemplates.end());
      }
     case QualifiedTemplate:
      {
        QualifiedTemplateName /*P*/ QTN = From.getAsQualifiedTemplateName();
        NestedNameSpecifier /*P*/ Qualifier = Import(QTN.getQualifier());
        if (!(Qualifier != null)) {
          return new TemplateName();
        }
        {
          
          TemplateDecl /*P*/ ToTemplate = cast_or_null_TemplateDecl(Import(From.getAsTemplateDecl()));
          if ((ToTemplate != null)) {
            return ToContext.getQualifiedTemplateName(Qualifier, 
                QTN.hasTemplateKeyword(), 
                ToTemplate);
          }
        }
        
        return new TemplateName();
      }
     case DependentTemplate:
      {
        DependentTemplateName /*P*/ DTN = From.getAsDependentTemplateName();
        NestedNameSpecifier /*P*/ Qualifier = Import(DTN.getQualifier());
        if (!(Qualifier != null)) {
          return new TemplateName();
        }
        if (DTN.isIdentifier()) {
          return ToContext.getDependentTemplateName(Qualifier, 
              Import(DTN.getIdentifier()));
        }
        
        return ToContext.getDependentTemplateName(Qualifier, DTN.getOperator());
      }
     case SubstTemplateTemplateParm:
      {
        SubstTemplateTemplateParmStorage /*P*/ subst = From.getAsSubstTemplateTemplateParm();
        TemplateTemplateParmDecl /*P*/ param = cast_or_null_TemplateTemplateParmDecl(Import(subst.getParameter()));
        if (!(param != null)) {
          return new TemplateName();
        }
        
        TemplateName replacement = Import(subst.getReplacement());
        if (replacement.isNull()) {
          return new TemplateName();
        }
        
        return ToContext.getSubstTemplateTemplateParm(param, new TemplateName(replacement));
      }
     case SubstTemplateTemplateParmPack:
      {
        SubstTemplateTemplateParmPackStorage /*P*/ SubstPack = From.getAsSubstTemplateTemplateParmPack();
        TemplateTemplateParmDecl /*P*/ Param = cast_or_null_TemplateTemplateParmDecl(Import(SubstPack.getParameterPack()));
        if (!(Param != null)) {
          return new TemplateName();
        }
        
        ASTNodeImporter Importer/*J*/= new ASTNodeImporter(/*Deref*/this);
        TemplateArgument ArgPack = Importer.ImportTemplateArgument(SubstPack.getArgumentPack());
        if (ArgPack.isNull()) {
          return new TemplateName();
        }
        
        return ToContext.getSubstTemplateTemplateParmPack(Param, ArgPack);
      }
    }
    throw new llvm_unreachable("Invalid template name kind");
  }

  
  /// \brief Import the given source location from the "from" context into
  /// the "to" context.
  ///
  /// \returns the equivalent source location in the "to" context, or an
  /// invalid source location if an error occurred.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTImporter::Import">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 6373,
   FQN="clang::ASTImporter::Import", NM="_ZN5clang11ASTImporter6ImportENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang11ASTImporter6ImportENS_14SourceLocationE")
  //</editor-fold>
  public SourceLocation Import(SourceLocation FromLoc) {
    if (FromLoc.isInvalid()) {
      return new SourceLocation();
    }
    
    final SourceManager /*&*/ FromSM = FromContext.getSourceManager();
    
    // For now, map everything down to its spelling location, so that we
    // don't have to import macro expansions.
    // FIXME: Import macro expansions!
    FromLoc.$assignMove(FromSM.getSpellingLoc(/*NO_COPY*/FromLoc));
    std.pairTypeUInt<FileID> Decomposed = FromSM.getDecomposedLoc(/*NO_COPY*/FromLoc);
    final SourceManager /*&*/ ToSM = ToContext.getSourceManager();
    FileID ToFileID = Import(new FileID(Decomposed.first));
    if (ToFileID.isInvalid()) {
      return new SourceLocation();
    }
    SourceLocation ret = ToSM.getLocForStartOfFile(/*NO_COPY*/ToFileID).
        getLocWithOffset(Decomposed.second);
    return ret;
  }

  
  /// \brief Import the given source range from the "from" context into
  /// the "to" context.
  ///
  /// \returns the equivalent source range in the "to" context, or an
  /// invalid source location if an error occurred.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTImporter::Import">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 6393,
   FQN="clang::ASTImporter::Import", NM="_ZN5clang11ASTImporter6ImportENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang11ASTImporter6ImportENS_11SourceRangeE")
  //</editor-fold>
  public SourceRange Import(SourceRange FromRange) {
    return new SourceRange(Import(FromRange.getBegin()), Import(FromRange.getEnd()));
  }

  
  /// \brief Import the given declaration name from the "from"
  /// context into the "to" context.
  ///
  /// \returns the equivalent declaration name in the "to" context,
  /// or an empty declaration name if an error occurred.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTImporter::Import">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 6550,
   FQN="clang::ASTImporter::Import", NM="_ZN5clang11ASTImporter6ImportENS_15DeclarationNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang11ASTImporter6ImportENS_15DeclarationNameE")
  //</editor-fold>
  public DeclarationName Import(DeclarationName FromName) {
    if (!FromName.$bool()) {
      return new DeclarationName();
    }
    switch (FromName.getNameKind()) {
     case Identifier:
      return new DeclarationName(Import(FromName.getAsIdentifierInfo()));
     case ObjCZeroArgSelector:
     case ObjCOneArgSelector:
     case ObjCMultiArgSelector:
      return new DeclarationName(Import(FromName.getObjCSelector()));
     case CXXConstructorName:
      {
        QualType T = Import(FromName.getCXXNameType());
        if (T.isNull()) {
          return new DeclarationName();
        }
        
        return ToContext.DeclarationNames.getCXXConstructorName(ToContext.getCanonicalType(/*NO_COPY*/T));
      }
     case CXXDestructorName:
      {
        QualType T = Import(FromName.getCXXNameType());
        if (T.isNull()) {
          return new DeclarationName();
        }
        
        return ToContext.DeclarationNames.getCXXDestructorName(ToContext.getCanonicalType(/*NO_COPY*/T));
      }
     case CXXConversionFunctionName:
      {
        QualType T = Import(FromName.getCXXNameType());
        if (T.isNull()) {
          return new DeclarationName();
        }
        
        return ToContext.DeclarationNames.getCXXConversionFunctionName(ToContext.getCanonicalType(/*NO_COPY*/T));
      }
     case CXXOperatorName:
      return ToContext.DeclarationNames.getCXXOperatorName(FromName.getCXXOverloadedOperator());
     case CXXLiteralOperatorName:
      return ToContext.DeclarationNames.getCXXLiteralOperatorName(Import(FromName.getCXXLiteralIdentifier()));
     case CXXUsingDirective:
      // FIXME: STATICS!
      return DeclarationName.getUsingDirectiveName();
    }
    throw new llvm_unreachable("Invalid DeclarationName Kind!");
  }

  
  /// \brief Import the given identifier from the "from" context
  /// into the "to" context.
  ///
  /// \returns the equivalent identifier in the "to" context.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTImporter::Import">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 6606,
   FQN="clang::ASTImporter::Import", NM="_ZN5clang11ASTImporter6ImportEPKNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang11ASTImporter6ImportEPKNS_14IdentifierInfoE")
  //</editor-fold>
  public IdentifierInfo /*P*/ Import(/*const*/ IdentifierInfo /*P*/ FromId) {
    if (!(FromId != null)) {
      return null;
    }
    
    IdentifierInfo /*P*/ ToId = $AddrOf(ToContext.Idents.get(FromId.getKeyArray(), FromId.getKeyArrayIndex(), FromId.getKeyLength()));
    if (!(ToId.getBuiltinID() != 0) && (FromId.getBuiltinID() != 0)) {
      ToId.setBuiltinID(FromId.getBuiltinID());
    }
    
    return ToId;
  }

  
  /// \brief Import the given Objective-C selector from the "from"
  /// context into the "to" context.
  ///
  /// \returns the equivalent selector in the "to" context.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTImporter::Import">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 6618,
   FQN="clang::ASTImporter::Import", NM="_ZN5clang11ASTImporter6ImportENS_8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang11ASTImporter6ImportENS_8SelectorE")
  //</editor-fold>
  public Selector Import(Selector FromSel) {
    if (FromSel.isNull()) {
      return new Selector();
    }
    
    SmallVector<IdentifierInfo /*P*/> Idents/*J*/= new SmallVector<IdentifierInfo /*P*/>(4, (IdentifierInfo /*P*/)null);
    Idents.push_back(Import(FromSel.getIdentifierInfoForSlot(0)));
    for (/*uint*/int I = 1, N = FromSel.getNumArgs(); $less_uint(I, N); ++I)  {
      Idents.push_back(Import(FromSel.getIdentifierInfoForSlot(I)));
    }
    return ToContext.Selectors.getSelector(FromSel.getNumArgs(), Idents.data());
  }

  
  /// \brief Import the given file ID from the "from" context into the 
  /// "to" context.
  ///
  /// \returns the equivalent file ID in the source manager of the "to"
  /// context.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTImporter::Import">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   optimized = Converted.Optimization.VALUE_TYPE,        
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 6397,
   FQN="clang::ASTImporter::Import", NM="_ZN5clang11ASTImporter6ImportENS_6FileIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang11ASTImporter6ImportENS_6FileIDE")
  //</editor-fold>
  public FileID Import(FileID FromID) {
    DenseMapIterator<FileID, FileID> Pos = ImportedFileIDs.find(FromID);
    if (Pos.$noteq(/*NO_ITER_COPY*/ImportedFileIDs.end())) {
      return new FileID(Pos.$arrow().second);
    }
    
    final SourceManager /*&*/ FromSM = FromContext.getSourceManager();
    final SourceManager /*&*/ ToSM = ToContext.getSourceManager();
    final /*const*/ SrcMgr.SLocEntry /*&*/ FromSLoc = FromSM.getSLocEntry(/*NO_COPY*/FromID);
    assert (FromSLoc.isFile()) : "Cannot handle macro expansions yet";
    
    // Include location of this file.
    SourceLocation ToIncludeLoc = Import(FromSLoc.getFile().getIncludeLoc());
    
    // Map the FileID for to the "to" source manager.
    FileID ToID/*J*/= new FileID();
    // JAVA: PERF
//    /*const*/ SrcMgr.ContentCache /*P*/ Cache = FromSLoc.getFile().getContentCache();
    /*const*/ SrcMgr.ContentCache /*P*/ Cache = FromSM.getContentCache(FromSLoc);
    if ((Cache.OrigEntry != null) && (Cache.OrigEntry.getDir() != null)) {
      // FIXME: We probably want to use getVirtualFile(), so we don't hit the
      // disk again
      // FIXME: We definitely want to re-use the existing MemoryBuffer, rather
      // than mmap the files several times.
      /*const*/ FileEntry /*P*/ Entry = ToFileManager.getFile(new StringRef(Cache.OrigEntry.getName()));
      if (!(Entry != null)) {
        return new FileID();
      }
      ToID.$assignMove(ToSM.createFileID(Entry, /*NO_COPY*/ToIncludeLoc, 
              FromSLoc.getFile().getFileCharacteristic()));
    } else {
      std.unique_ptr<MemoryBuffer> ToBuf = null;
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // FIXME: We want to re-use the existing MemoryBuffer!
        /*const*/ MemoryBuffer /*P*/ FromBuf = Cache.getBuffer(FromContext.getDiagnostics(), FromSM);
        ToBuf = MemoryBuffer.getMemBufferCopy(FromBuf.getBuffer(), 
            new Twine(FromBuf.getBufferIdentifier()));
        $c$.clean(ToID.$assignMove(ToSM.createFileID($c$.track(new std.unique_ptr<MemoryBuffer>(JD$Move.INSTANCE, std.move(ToBuf))), 
                FromSLoc.getFile().getFileCharacteristic())));
      } finally {
        if (ToBuf != null) { ToBuf.$destroy(); }
        $c$.$destroy();
      }
    }
    
    ImportedFileIDs.$at_T1$C$R(FromID).$assign(ToID);
    return ToID;
  }

  
  /// \brief Import the given C++ constructor initializer from the "from"
  /// context into the "to" context.
  ///
  /// \returns the equivalent initializer in the "to" context.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTImporter::Import">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 6440,
   FQN="clang::ASTImporter::Import", NM="_ZN5clang11ASTImporter6ImportEPNS_18CXXCtorInitializerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang11ASTImporter6ImportEPNS_18CXXCtorInitializerE")
  //</editor-fold>
  public CXXCtorInitializer /*P*/ Import(CXXCtorInitializer /*P*/ From) {
    Expr /*P*/ ToExpr = Import(From.getInit());
    if (!(ToExpr != null) && (From.getInit() != null)) {
      return null;
    }
    if (From.isBaseInitializer()) {
      TypeSourceInfo /*P*/ ToTInfo = Import(From.getTypeSourceInfo());
      if (!(ToTInfo != null) && (From.getTypeSourceInfo() != null)) {
        return null;
      }
      
      return /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (ToContext)*/ $new_uint_ASTContext$C_uint(ToContext, (type$ptr<?> New$Mem)->{
          return new CXXCtorInitializer(ToContext, ToTInfo, From.isBaseVirtual(), Import(From.getLParenLoc()), 
                  ToExpr, Import(From.getRParenLoc()), 
                  From.isPackExpansion() ? Import(From.getEllipsisLoc()) : new SourceLocation());
       });
    } else if (From.isMemberInitializer()) {
      FieldDecl /*P*/ ToField = cast_or_null_FieldDecl(Import(From.getMember()));
      if (!(ToField != null) && (From.getMember() != null)) {
        return null;
      }
      
      return /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (ToContext)*/ $new_uint_ASTContext$C_uint(ToContext, (type$ptr<?> New$Mem)->{
          return new CXXCtorInitializer(ToContext, ToField, Import(From.getMemberLocation()), 
                  Import(From.getLParenLoc()), ToExpr, Import(From.getRParenLoc()));
       });
    } else if (From.isIndirectMemberInitializer()) {
      IndirectFieldDecl /*P*/ ToIField = cast_or_null_IndirectFieldDecl(Import(From.getIndirectMember()));
      if (!(ToIField != null) && (From.getIndirectMember() != null)) {
        return null;
      }
      
      return /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (ToContext)*/ $new_uint_ASTContext$C_uint(ToContext, (type$ptr<?> New$Mem)->{
          return new CXXCtorInitializer(ToContext, ToIField, Import(From.getMemberLocation()), 
                  Import(From.getLParenLoc()), ToExpr, Import(From.getRParenLoc()));
       });
    } else if (From.isDelegatingInitializer()) {
      TypeSourceInfo /*P*/ ToTInfo = Import(From.getTypeSourceInfo());
      if (!(ToTInfo != null) && (From.getTypeSourceInfo() != null)) {
        return null;
      }
      
      return /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
      /*new (ToContext)*/ $new_uint_ASTContext$C_uint(ToContext, (type$ptr<?> New$Mem)->{
          return new CXXCtorInitializer(ToContext, ToTInfo, Import(From.getLParenLoc()), 
                  ToExpr, Import(From.getRParenLoc()));
       });
    } else {
      /*uint*/int NumArrayIndices = From.getNumArrayIndices();
      if ((NumArrayIndices != 0)) {
        FieldDecl /*P*/ ToField = cast_or_null_FieldDecl(Import(From.getMember()));
        if (!(ToField != null) && (From.getMember() != null)) {
          return null;
        }
        
        SmallVector<VarDecl /*P*/ > ToAIs/*J*/= new SmallVector<VarDecl /*P*/ >(JD$UInt_T$C$R.INSTANCE, 4, NumArrayIndices, (VarDecl /*P*/ )null);
        
        for (/*uint*/int AII = 0; $less_uint(AII, NumArrayIndices); ++AII) {
          VarDecl /*P*/ ToArrayIndex = dyn_cast_or_null_VarDecl(Import(From.getArrayIndex(AII)));
          if (!(ToArrayIndex != null) && (From.getArrayIndex(AII) != null)) {
            return null;
          }
        }
        
        return CXXCtorInitializer.Create(ToContext, ToField, Import(From.getMemberLocation()), 
            Import(From.getLParenLoc()), ToExpr, Import(From.getRParenLoc()), 
            ToAIs.data(), NumArrayIndices);
      } else {
        return null;
      }
    }
  }

  
  /// \brief Import the definition of the given declaration, including all of
  /// the declarations it contains.
  ///
  /// This routine is intended to be used 
  //<editor-fold defaultstate="collapsed" desc="clang::ASTImporter::ImportDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 6506,
   FQN="clang::ASTImporter::ImportDefinition", NM="_ZN5clang11ASTImporter16ImportDefinitionEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang11ASTImporter16ImportDefinitionEPNS_4DeclE")
  //</editor-fold>
  public void ImportDefinition(Decl /*P*/ From) {
    Decl /*P*/ To = Import(From);
    if (!(To != null)) {
      return;
    }
    {
      
      DeclContext /*P*/ FromDC = cast_DeclContext(From);
      if ((FromDC != null)) {
        ASTNodeImporter Importer/*J*/= new ASTNodeImporter(/*Deref*/this);
        {
          
          RecordDecl /*P*/ ToRecord = dyn_cast_RecordDecl(To);
          if ((ToRecord != null)) {
            if (!(ToRecord.getDefinition() != null)) {
              Importer.ImportDefinition(cast_RecordDecl(FromDC), ToRecord, 
                  ASTNodeImporter.ImportDefinitionKind.IDK_Everything);
              return;
            }
          }
        }
        {
          
          EnumDecl /*P*/ ToEnum = dyn_cast_EnumDecl(To);
          if ((ToEnum != null)) {
            if (!(ToEnum.getDefinition() != null)) {
              Importer.ImportDefinition(cast_EnumDecl(FromDC), ToEnum, 
                  ASTNodeImporter.ImportDefinitionKind.IDK_Everything);
              return;
            }
          }
        }
        {
          
          ObjCInterfaceDecl /*P*/ ToIFace = dyn_cast_ObjCInterfaceDecl(To);
          if ((ToIFace != null)) {
            if (!(ToIFace.getDefinition() != null)) {
              Importer.ImportDefinition(cast_ObjCInterfaceDecl(FromDC), ToIFace, 
                  ASTNodeImporter.ImportDefinitionKind.IDK_Everything);
              return;
            }
          }
        }
        {
          
          ObjCProtocolDecl /*P*/ ToProto = dyn_cast_ObjCProtocolDecl(To);
          if ((ToProto != null)) {
            if (!(ToProto.getDefinition() != null)) {
              Importer.ImportDefinition(cast_ObjCProtocolDecl(FromDC), ToProto, 
                  ASTNodeImporter.ImportDefinitionKind.IDK_Everything);
              return;
            }
          }
        }
        
        Importer.ImportDeclContext(FromDC, true);
      }
    }
  }

  
  /// \brief Cope with a name conflict when importing a declaration into the
  /// given context.
  ///
  /// This routine is invoked whenever there is a name conflict while 
  /// importing a declaration. The returned name will become the name of the
  /// imported declaration. By default, the returned name is the same as the
  /// original name, leaving the conflict unresolve such that name lookup
  /// for this name is likely to find an ambiguity later.
  ///
  /// Subclasses may override this routine to resolve the conflict, e.g., by
  /// renaming the declaration being imported.
  ///
  /// \param Name the name of the declaration being imported, which conflicts
  /// with other declarations.
  ///
  /// \param DC the declaration context (in the "to" AST context) in which 
  /// the name is being imported.
  ///
  /// \param IDNS the identifier namespace in which the name will be found.
  ///
  /// \param Decls the set of declarations with the same name as the
  /// declaration being imported.
  ///
  /// \param NumDecls the number of conflicting declarations in \p Decls.
  ///
  /// \returns the name that the newly-imported declaration should have.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTImporter::HandleNameConflict">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 6629,
   FQN="clang::ASTImporter::HandleNameConflict", NM="_ZN5clang11ASTImporter18HandleNameConflictENS_15DeclarationNameEPNS_11DeclContextEjPPNS_9NamedDeclEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang11ASTImporter18HandleNameConflictENS_15DeclarationNameEPNS_11DeclContextEjPPNS_9NamedDeclEj")
  //</editor-fold>
  public DeclarationName HandleNameConflict(DeclarationName Name, 
                    DeclContext /*P*/ DC, 
                    /*uint*/int IDNS, 
                    type$ptr<NamedDecl /*P*/ /*P*/> Decls, 
                    /*uint*/int NumDecls) {
    return new DeclarationName(JD$Move.INSTANCE, Name);
  }

  
  /// \brief Retrieve the context that AST nodes are being imported into.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTImporter::getToContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTImporter.h", line = 256,
   FQN="clang::ASTImporter::getToContext", NM="_ZNK5clang11ASTImporter12getToContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZNK5clang11ASTImporter12getToContextEv")
  //</editor-fold>
  public ASTContext /*&*/ getToContext() /*const*/ {
    return ToContext;
  }

  
  /// \brief Retrieve the context that AST nodes are being imported from.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTImporter::getFromContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTImporter.h", line = 259,
   FQN="clang::ASTImporter::getFromContext", NM="_ZNK5clang11ASTImporter14getFromContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZNK5clang11ASTImporter14getFromContextEv")
  //</editor-fold>
  public ASTContext /*&*/ getFromContext() /*const*/ {
    return FromContext;
  }

  
  /// \brief Retrieve the file manager that AST nodes are being imported into.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTImporter::getToFileManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTImporter.h", line = 262,
   FQN="clang::ASTImporter::getToFileManager", NM="_ZNK5clang11ASTImporter16getToFileManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZNK5clang11ASTImporter16getToFileManagerEv")
  //</editor-fold>
  public FileManager /*&*/ getToFileManager() /*const*/ {
    return ToFileManager;
  }

  
  /// \brief Retrieve the file manager that AST nodes are being imported from.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTImporter::getFromFileManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTImporter.h", line = 265,
   FQN="clang::ASTImporter::getFromFileManager", NM="_ZNK5clang11ASTImporter18getFromFileManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZNK5clang11ASTImporter18getFromFileManagerEv")
  //</editor-fold>
  public FileManager /*&*/ getFromFileManager() /*const*/ {
    return FromFileManager;
  }

  
  /// \brief Report a diagnostic in the "to" context.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTImporter::ToDiag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 6637,
   FQN="clang::ASTImporter::ToDiag", NM="_ZN5clang11ASTImporter6ToDiagENS_14SourceLocationEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang11ASTImporter6ToDiagENS_14SourceLocationEj")
  //</editor-fold>
  public DiagnosticBuilder ToDiag(SourceLocation Loc, /*uint*/int DiagID) {
    if (LastDiagFromFrom) {
      ToContext.getDiagnostics().notePriorDiagnosticFrom(FromContext.getDiagnostics());
    }
    LastDiagFromFrom = false;
    return ToContext.getDiagnostics().Report(/*NO_COPY*/Loc, DiagID);
  }

  
  /// \brief Report a diagnostic in the "from" context.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTImporter::FromDiag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 6645,
   FQN="clang::ASTImporter::FromDiag", NM="_ZN5clang11ASTImporter8FromDiagENS_14SourceLocationEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang11ASTImporter8FromDiagENS_14SourceLocationEj")
  //</editor-fold>
  public DiagnosticBuilder FromDiag(SourceLocation Loc, /*uint*/int DiagID) {
    if (!LastDiagFromFrom) {
      FromContext.getDiagnostics().notePriorDiagnosticFrom(ToContext.getDiagnostics());
    }
    LastDiagFromFrom = true;
    return FromContext.getDiagnostics().Report(/*NO_COPY*/Loc, DiagID);
  }

  
  /// \brief Return the set of declarations that we know are not equivalent.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTImporter::getNonEquivalentDecls">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTImporter.h", line = 274,
   FQN="clang::ASTImporter::getNonEquivalentDecls", NM="_ZN5clang11ASTImporter21getNonEquivalentDeclsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang11ASTImporter21getNonEquivalentDeclsEv")
  //</editor-fold>
  public DenseSet<std.pair<Decl /*P*/ , Decl /*P*/ > >/*&*/ getNonEquivalentDecls() {
    return NonEquivalentDecls;
  }

  
  /// \brief Called for ObjCInterfaceDecl, ObjCProtocolDecl, and TagDecl.
  /// Mark the Decl as complete, filling it in as much as possible.
  ///
  /// \param D A declaration in the "to" context.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTImporter::CompleteDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 6653,
   FQN="clang::ASTImporter::CompleteDecl", NM="_ZN5clang11ASTImporter12CompleteDeclEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang11ASTImporter12CompleteDeclEPNS_4DeclE")
  //</editor-fold>
  public void CompleteDecl(Decl /*P*/ D) {
    {
      ObjCInterfaceDecl /*P*/ ID = dyn_cast_ObjCInterfaceDecl(D);
      if ((ID != null)) {
        if (!(ID.getDefinition() != null)) {
          ID.startDefinition();
        }
      } else {
        ObjCProtocolDecl /*P*/ PD = dyn_cast_ObjCProtocolDecl(D);
        if ((PD != null)) {
          if (!(PD.getDefinition() != null)) {
            PD.startDefinition();
          }
        } else {
          TagDecl /*P*/ TD = dyn_cast_TagDecl(D);
          if ((TD != null)) {
            if (!(TD.getDefinition() != null) && !TD.isBeingDefined()) {
              TD.startDefinition();
              TD.setCompleteDefinition(true);
            }
          } else {
            assert (false) : "CompleteDecl called on a Decl that can't be completed";
          }
        }
      }
    }
  }

  
  /// \brief Note that we have imported the "from" declaration by mapping it
  /// to the (potentially-newly-created) "to" declaration.
  ///
  /// Subclasses can override this function to observe all of the \c From ->
  /// \c To declaration mappings as they are imported.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTImporter::Imported">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 6673,
   FQN="clang::ASTImporter::Imported", NM="_ZN5clang11ASTImporter8ImportedEPNS_4DeclES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang11ASTImporter8ImportedEPNS_4DeclES2_")
  //</editor-fold>
  public Decl /*P*/ Imported(Decl /*P*/ From, Decl /*P*/ To) {
    if (From.hasAttrs()) {
      for (Attr /*P*/ FromAttr : From.getAttrs())  {
        To.addAttr(FromAttr.clone(To.getASTContext()));
      }
    }
    if (From.isUsed()) {
      To.setIsUsed();
    }
    if (From.isImplicit()) {
      To.setImplicit();
    }
    ImportedDecls.$set(From, To);
    return To;
  }

  
  /// \brief Called by StructuralEquivalenceContext.  If a RecordDecl is
  /// being compared to another RecordDecl as part of import, completing the
  /// other RecordDecl may trigger importation of the first RecordDecl. This
  /// happens especially for anonymous structs.  If the original of the second
  /// RecordDecl can be found, we can complete it without the need for
  /// importation, eliminating this loop.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTImporter::GetOriginalDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTImporter.h", line = 295,
   FQN="clang::ASTImporter::GetOriginalDecl", NM="_ZN5clang11ASTImporter15GetOriginalDeclEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang11ASTImporter15GetOriginalDeclEPNS_4DeclE")
  //</editor-fold>
  public /*virtual*/ Decl /*P*/ GetOriginalDecl(Decl /*P*/ To) {
    return null;
  }

  
  /// \brief Determine whether the given types are structurally
  /// equivalent.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTImporter::IsStructurallyEquivalent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 6688,
   FQN="clang::ASTImporter::IsStructurallyEquivalent", NM="_ZN5clang11ASTImporter24IsStructurallyEquivalentENS_8QualTypeES1_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN5clang11ASTImporter24IsStructurallyEquivalentENS_8QualTypeES1_b")
  //</editor-fold>
  public boolean IsStructurallyEquivalent(QualType From, QualType To) {
    return IsStructurallyEquivalent(From, To, 
                          true);
  }
  public boolean IsStructurallyEquivalent(QualType From, QualType To, 
                          boolean Complain/*= true*/) {
    StructuralEquivalenceContext Ctx = null;
    try {
      DenseMapIterator</*const*/ Type /*P*/ , /*const*/ Type /*P*/ > Pos = ImportedTypes.find(From.getTypePtr());
      if (Pos.$noteq(/*NO_ITER_COPY*/ImportedTypes.end()) && ToContext.hasSameType(Import(new QualType(From)), new QualType(To))) {
        return true;
      }
      
      Ctx/*J*/= new StructuralEquivalenceContext(FromContext, ToContext, NonEquivalentDecls, 
          false, Complain);
      return Ctx.IsStructurallyEquivalent(new QualType(From), new QualType(To));
    } finally {
      if (Ctx != null) { Ctx.$destroy(); }
    }
  }

  
  @Override public String toString() {
    return "" + "ToContext=" + "[ASTContext]" // NOI18N
              + ", FromContext=" + "[ASTContext]" // NOI18N
              + ", ToFileManager=" + "[FileManager]" // NOI18N
              + ", FromFileManager=" + "[FileManager]" // NOI18N
              + ", Minimal=" + Minimal // NOI18N
              + ", LastDiagFromFrom=" + LastDiagFromFrom // NOI18N
              + ", ImportedTypes=" + ImportedTypes // NOI18N
              + ", ImportedDecls=" + ImportedDecls // NOI18N
              + ", ImportedStmts=" + ImportedStmts // NOI18N
              + ", ImportedFileIDs=" + ImportedFileIDs // NOI18N
              + ", AnonTagsWithPendingTypedefs=" + AnonTagsWithPendingTypedefs // NOI18N
              + ", NonEquivalentDecls=" + NonEquivalentDecls; // NOI18N
  }
}
