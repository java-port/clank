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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.ast.impl.DeclStatics.*;


/// \brief Describes a module import declaration, which makes the contents
/// of the named module visible in the current translation unit.
///
/// An import declaration imports the named module (or submodule). For example:
/// \code
///   @import std.vector;
/// \endcode
///
/// Import declarations can also be implicitly generated from
/// \#include/\#import directives.
//<editor-fold defaultstate="collapsed" desc="clang::ImportDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3728,
 FQN="clang::ImportDecl", NM="_ZN5clang10ImportDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang10ImportDeclE")
//</editor-fold>
public final class ImportDecl extends /*public*/ Decl implements TrailingObjects<ImportDecl, SourceLocation>, Destructors.ClassWithDestructor {
  /// \brief The imported module, along with a bit that indicates whether
  /// we have source-location information for each identifier in the module
  /// name. 
  ///
  /// When the bit is false, we only have a single source location for the
  /// end of the import declaration.
  /*friend*/public PointerBoolPair</*const*/ Module/*P*/> ImportedAndComplete;
  
  /// \brief The next import in the list of imports local to the translation
  /// unit being parsed (not loaded from an AST file).
  /*friend*//*private*/ ImportDecl /*P*/ NextLocalImport;
  
  /*friend  class ASTReader*/
  /*friend  class ASTDeclReader*/
  /*friend  class ASTContext*/
  /*friend  TrailingObjects<ImportDecl, SourceLocation>*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::ImportDecl::ImportDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 4225,
   FQN="clang::ImportDecl::ImportDecl", NM="_ZN5clang10ImportDeclC1EPNS_11DeclContextENS_14SourceLocationEPNS_6ModuleEN4llvm8ArrayRefIS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang10ImportDeclC1EPNS_11DeclContextENS_14SourceLocationEPNS_6ModuleEN4llvm8ArrayRefIS3_EE")
  //</editor-fold>
  private ImportDecl(DeclContext /*P*/ DC, SourceLocation StartLoc, 
      Module /*P*/ Imported, 
      ArrayRef<SourceLocation> IdentifierLocs) {
    // : Decl(Import, DC, StartLoc), TrailingObjects<ImportDecl, SourceLocation>(), ImportedAndComplete(Imported, true), NextLocalImport(implicit ImportDecl * ()) 
    //START JInit
    super(Kind.Import, DC, new SourceLocation(StartLoc));
    $TrailingObjects();
    this.ImportedAndComplete = new PointerBoolPair</*const*/ Module/*P*/>(Imported, true);
    this.NextLocalImport = /*implicit-init*/((ImportDecl /*P*/ )/*zero-init*/null);
    //END JInit
    assert (getNumModuleIdentifiers(Imported) == IdentifierLocs.size());
    type$ptr<SourceLocation> /*P*/ StoredLocs = $tryClone(this.<SourceLocation>getTrailingObjects(SourceLocation.class));
    std.uninitialized_copy(IdentifierLocs.begin(), IdentifierLocs.end(), 
        StoredLocs);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ImportDecl::ImportDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 4237,
   FQN="clang::ImportDecl::ImportDecl", NM="_ZN5clang10ImportDeclC1EPNS_11DeclContextENS_14SourceLocationEPNS_6ModuleES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang10ImportDeclC1EPNS_11DeclContextENS_14SourceLocationEPNS_6ModuleES3_")
  //</editor-fold>
  private ImportDecl(DeclContext /*P*/ DC, SourceLocation StartLoc, 
      Module /*P*/ Imported, SourceLocation EndLoc) {
    // : Decl(Import, DC, StartLoc), TrailingObjects<ImportDecl, SourceLocation>(), ImportedAndComplete(Imported, false), NextLocalImport(implicit ImportDecl * ()) 
    //START JInit
    super(Kind.Import, DC, new SourceLocation(StartLoc));
    $TrailingObjects();
    this.ImportedAndComplete = new PointerBoolPair</*const*/ Module/*P*/>(Imported, false);
    this.NextLocalImport = /*implicit-init*/((ImportDecl /*P*/ )/*zero-init*/null);
    //END JInit
    this.<SourceLocation>getTrailingObjects(SourceLocation.class).$set(EndLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ImportDecl::ImportDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3753,
   FQN="clang::ImportDecl::ImportDecl", NM="_ZN5clang10ImportDeclC1ENS_4Decl10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang10ImportDeclC1ENS_4Decl10EmptyShellE")
  //</editor-fold>
  private ImportDecl(EmptyShell Empty) {
    // : Decl(Import, Empty), TrailingObjects<ImportDecl, SourceLocation>(), ImportedAndComplete(), NextLocalImport(implicit ImportDecl * ()) 
    //START JInit
    super(Kind.Import, new EmptyShell(Empty));
    $TrailingObjects();
    this.ImportedAndComplete = new PointerBoolPair</*const*/ Module/*P*/>();
    this.NextLocalImport = /*implicit-init*/((ImportDecl /*P*/ )/*zero-init*/null);
    //END JInit
  }

/*public:*/
  /// \brief Create a new module import declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::ImportDecl::Create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 4245,
   FQN="clang::ImportDecl::Create", NM="_ZN5clang10ImportDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationEPNS_6ModuleEN4llvm8ArrayRefIS5_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang10ImportDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationEPNS_6ModuleEN4llvm8ArrayRefIS5_EE")
  //</editor-fold>
  public static ImportDecl /*P*/ Create(final ASTContext /*&*/ C, DeclContext /*P*/ DC, 
        SourceLocation StartLoc, Module /*P*/ Imported, 
        ArrayRef<SourceLocation> IdentifierLocs) {
    final int Extra = TrailingObjects.additionalSizeToAlloc$Same(SourceLocation.class, IdentifierLocs.size());
    return /*NEW_EXPR [Decl::new]*//*new (C, DC, additionalSizeToAlloc<SourceLocation>(IdentifierLocs.size()))*/ Decl.$new(C, DC, Extra, (type$ptr<?> Mem)->{
        return new ImportDecl(DC, new SourceLocation(StartLoc), Imported, new ArrayRef<SourceLocation>(IdentifierLocs));
     },
       new std.pairIntPtr<>(Extra, SourceLocation::new) // for SourceLocation
     );
  }

  
  /// \brief Create a new module import declaration for an implicitly-generated
  /// import.
  //<editor-fold defaultstate="collapsed" desc="clang::ImportDecl::CreateImplicit">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 4253,
   FQN="clang::ImportDecl::CreateImplicit", NM="_ZN5clang10ImportDecl14CreateImplicitERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationEPNS_6ModuleES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang10ImportDecl14CreateImplicitERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationEPNS_6ModuleES5_")
  //</editor-fold>
  public static ImportDecl /*P*/ CreateImplicit(final ASTContext /*&*/ C, DeclContext /*P*/ DC, 
                SourceLocation StartLoc, 
                Module /*P*/ Imported, 
                SourceLocation EndLoc) {
    final int Extra = TrailingObjects.additionalSizeToAlloc$Same(SourceLocation.class, 1);
    ImportDecl /*P*/ Import = /*NEW_EXPR [Decl::new]*//*new (C, DC, additionalSizeToAlloc<SourceLocation>(1))*/Decl.$new(C, DC, Extra, (type$ptr<?> Mem)->{
        return new ImportDecl(DC, new SourceLocation(StartLoc), Imported, new SourceLocation(EndLoc));
     },
      new std.pairIntPtr<>(Extra, SourceLocation::new) // for SourceLocation
     );
    Import.setImplicit();
    return Import;
  }

  
  /// \brief Create a new, deserialized module import declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::ImportDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 4263,
   FQN="clang::ImportDecl::CreateDeserialized", NM="_ZN5clang10ImportDecl18CreateDeserializedERNS_10ASTContextEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang10ImportDecl18CreateDeserializedERNS_10ASTContextEjj")
  //</editor-fold>
  public static ImportDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, /*uint*/int ID, 
                    /*uint*/int NumLocations) {
    return /*NEW_EXPR [Decl::new]*//*new (C, ID, additionalSizeToAlloc<SourceLocation>(NumLocations))*/ Decl.$new(C, ID, TrailingObjects.additionalSizeToAlloc$Same(SourceLocation.class, NumLocations), (type$ptr<?> Mem)->{
        return new ImportDecl(new EmptyShell());
     },
      new std.pairIntPtr<>(NumLocations, SourceLocation::new) // for SourceLocation
     );
  }

  
  /// \brief Retrieve the module that was imported by the import declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::ImportDecl::getImportedModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3772,
   FQN="clang::ImportDecl::getImportedModule", NM="_ZNK5clang10ImportDecl17getImportedModuleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang10ImportDecl17getImportedModuleEv")
  //</editor-fold>
  public Module /*P*/ getImportedModule() /*const*/ {
    return ImportedAndComplete.getPointer();
  }

  
  /// \brief Retrieves the locations of each of the identifiers that make up
  /// the complete module name in the import declaration.
  ///
  /// This will return an empty array if the locations of the individual
  /// identifiers aren't available.
  //<editor-fold defaultstate="collapsed" desc="clang::ImportDecl::getIdentifierLocs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 4269,
   FQN="clang::ImportDecl::getIdentifierLocs", NM="_ZNK5clang10ImportDecl17getIdentifierLocsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang10ImportDecl17getIdentifierLocsEv")
  //</editor-fold>
  public ArrayRef<SourceLocation> getIdentifierLocs() /*const*/ {
    if (!ImportedAndComplete.getInt()) {
      return new ArrayRef<SourceLocation>(None, false);
    }
    
    /*const*/type$ptr<SourceLocation> /*P*/ StoredLocs = $tryClone(this.<SourceLocation>getTrailingObjects$Const(SourceLocation.class));
    return llvm.makeArrayRef(StoredLocs, 
        getNumModuleIdentifiers(getImportedModule()), false);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ImportDecl::getSourceRange">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 4278,
   FQN="clang::ImportDecl::getSourceRange", NM="_ZNK5clang10ImportDecl14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang10ImportDecl14getSourceRangeEv")
  //</editor-fold>
  @Override public SourceRange getSourceRange() /*const*//* __attribute__((pure)) override*/ {
    if (!ImportedAndComplete.getInt()) {
      return new SourceRange(getLocation(), /*NO_COPY*/this.<SourceLocation>getTrailingObjects$Const(SourceLocation.class).$star());
    }
    
    return new SourceRange(getLocation(), /*NO_COPY*/getIdentifierLocs().back());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ImportDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3783,
   FQN="clang::ImportDecl::classof", NM="_ZN5clang10ImportDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang10ImportDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ImportDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3784,
   FQN="clang::ImportDecl::classofKind", NM="_ZN5clang10ImportDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang10ImportDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K == Kind.Import;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ImportDecl::~ImportDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3728,
   FQN="clang::ImportDecl::~ImportDecl", NM="_ZN5clang10ImportDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang10ImportDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
    TrailingObjects.super.$destroy$TrailingObjects();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  @Override
  public type$ptr<?> $TrailingObjects() {
    return $This$Ptr().$add(1); // skip this class
  }
  
  @Override
  public int getTrailingObjects$Offset(Class<?> clazz) {
    assert clazz == SourceLocation.class;
    return 0;
  }

  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "ImportedAndComplete=" + ImportedAndComplete // NOI18N
              + ", NextLocalImport=" + NextLocalImport // NOI18N
              + super.toString(); // NOI18N
  }
}
